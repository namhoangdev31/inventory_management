package com.example.full_stack_ktor.services

import com.example.full_stack_ktor.model.Article
import io.kvision.remote.getService
import org.w3c.fetch.RequestInit

object ArticleManager {
    private val articleManager = getService<IArticleService>(
        requestFilter = null as (suspend RequestInit.() -> Unit)?
    )

    suspend fun article(slug: String): Article {
        return articleManager.article(slug)
    }

    suspend fun createArticle(title: String?, description: String?, body: String?, tags: List<String>): Article {
        return articleManager.createArticle(title, description, body, tags)
    }

    suspend fun updateArticle(
        slug: String,
        title: String?,
        description: String?,
        body: String?,
        tags: List<String>
    ): Article {
        return articleManager.updateArticle(slug, title, description, body, tags)
    }

    suspend fun deleteArticle(slug: String) {
        articleManager.deleteArticle(slug)
    }


}