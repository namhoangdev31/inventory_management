package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.model.Article
import io.kvision.remote.getService

object ArticleManager {
    private val articleService = getService<IArticleService>()

    suspend fun article(slug: String): Article {
        return articleService.article(slug)
    }

    suspend fun createArticle(title: String?, description: String?, body: String?, tags: List<String>): Article {
        return articleService.createArticle(title, description, body, tags)
    }

    suspend fun updateArticle(slug: String, title: String?, description: String?, body: String?, tags: List<String>): Article {
        return articleService.updateArticle(slug, title, description, body, tags)
    }

    suspend fun deleteArticle(slug: String) {
        articleService.deleteArticle(slug)
    }


}