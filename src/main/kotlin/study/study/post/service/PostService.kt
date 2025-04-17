package study.study.post.service

import org.springframework.stereotype.Service
import study.study.post.dto.BoardDtoRequest
import study.study.post.repository.BoardRepository

@Service
class BoardService(
    private val boardRepository: BoardRepository,
) {
    /**
     * 게시글 작성
     */
    fun boardPost(boardDtoRequest: BoardDtoRequest, usernameFromToken: String) : String {
        val user = userRepository.findByUsername(usernameFromToken)
            ?: throw IllegalStateException("User not found")

        val writerName = user.name
        val board = boardDtoRequest.toEntity(writer = writerName)
        boardRepository.save(board)
        return "게시글 작성 완료"
    }
}