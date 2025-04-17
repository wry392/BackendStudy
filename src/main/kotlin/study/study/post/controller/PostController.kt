package study.study.post.controller

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.study.post.dto.BoardDtoRequest
import study.study.post.service.BoardService
import study.study.common.dto.BaseResponse
import java.security.Principal

@RestController
@RequestMapping("/api/board")
class BoardController (
    private val boardService: BoardService
) {
    /**
     * 게시글 작성
     */
    @PostMapping("/")
    fun boardPost(@RequestBody @Valid boardDtoRequest: BoardDtoRequest, principal: Principal): BaseResponse<String>{
        val userName = principal.name
        val result = boardService.boardPost(boardDtoRequest, userName)
        return BaseResponse(result)
    }
}