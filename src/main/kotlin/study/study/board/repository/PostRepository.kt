package study.study.board.repository

import study.study.board.model.Post

class PostRepository {
    private val posts = mutableListOf<Post>()

    fun findAll(): List<Post> = posts

    fun save(post: Post): Post {
        posts.add(post)
        return post
    }

    fun findById(id: Long): Post? = posts.find { it.id == id }
}