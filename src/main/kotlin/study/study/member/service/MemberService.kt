package study.study.member.service

import jakarta.transaction.Transactional
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.stereotype.Service
import study.study.common.authority.JwtTokenProvider
import study.study.common.authority.TokenInfo
import study.study.common.exception.InvalidInputException
import study.study.member.dto.MemberDtoRequest
import study.study.member.entitiy.Member
import study.study.member.repository.MemberRepository
import study.study.member.repository.MemberRoleRepository
import study.study.member.entitiy.MemberRole
import study.study.common.status.ROLE
import study.study.member.dto.LoginDto


@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val memberRoleRepository: MemberRoleRepository,
    // 추가
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
    private val jwtTokenProvider: JwtTokenProvider,
    ) {
    /**
     * 회원가입
     */
    fun signUp(memberDtoRequest: MemberDtoRequest): String {
        var member = memberRepository.findByLoginId(memberDtoRequest.loginId)
        if (member != null) {
            throw InvalidInputException("loginId", "이미 등록된 ID 입니다.")
        }
        member = memberDtoRequest.toEntity()
        memberRepository.save(member)

        //권한 저장
        val memberRole = MemberRole(null, ROLE.MEMBER, member)
        memberRoleRepository.save(memberRole)

        return "회원가입이 완료되었습니다."
    }

    /**
     * 로그인
     */
    fun login(loginDto: LoginDto): TokenInfo {
        val authenticationToken = UsernamePasswordAuthenticationToken(loginDto.loginId, loginDto.password)
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)
        return jwtTokenProvider.createToken(authentication)
    }
}