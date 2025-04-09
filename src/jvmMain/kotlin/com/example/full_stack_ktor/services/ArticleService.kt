package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.model.Article
import com.example.full_stack_ktor.model.ArticlesDto
import com.example.full_stack_ktor.model.Comment
@Suppress("ACTUAL_WITHOUT_EXPECT")
actual class ArticleService: IArticleService {
    override suspend fun articles(
        tag: String?,
        author: String?,
        favorited: String?,
        offset: Int,
        limit: Int
    ): ArticlesDto {
        TODO("Not yet implemented")
    }

    override suspend fun feed(offset: Int, limit: Int): ArticlesDto {
        TODO("Not yet implemented")
    }

    override suspend fun tags(): List<String> {
        TODO("Not yet implemented")
    }

    override suspend fun article(slug: String): Article {
        TODO("Not yet implemented")
    }

    override suspend fun articleComments(slug: String): List<Comment> {
        TODO("Not yet implemented")
    }

    override suspend fun articleFavorite(slug: String, favorite: Boolean): Article {
        TODO("Not yet implemented")
    }

    override suspend fun createArticle(
        title: String?,
        description: String?,
        body: String?,
        tags: List<String>
    ): Article {
        TODO("Not yet implemented")
    }

    override suspend fun updateArticle(
        slug: String,
        title: String?,
        description: String?,
        body: String?,
        tags: List<String>
    ): Article {
        TODO("Not yet implemented")
    }

    override suspend fun deleteArticle(slug: String) {
        TODO("Not yet implemented")
    }

    override suspend fun articleComment(slug: String, comment: String?): Comment {
        TODO("Not yet implemented")
    }

    override suspend fun articleCommentDelete(slug: String, id: Int) {
        TODO("Not yet implemented")
    }
}