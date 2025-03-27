package study.study.member.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.study.member.entitiy.Member

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByLoginId(loginId: String): Member?
    fun email(email: String): MutableList<Member>
}