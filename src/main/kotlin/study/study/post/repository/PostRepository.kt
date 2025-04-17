package study.study.post.repository

import org.apache.catalina.User
import org.springframework.data.jpa.repository.JpaRepository
import study.study.post.entity.Board

interface BoardRepository : JpaRepository<Board, Long>

interface UserRepository : JpaRepository<User, Long> {
    fun findByusername(username: String): User?
}