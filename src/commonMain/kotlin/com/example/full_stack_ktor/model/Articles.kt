@file:UseContextualSerialization(OffsetDateTime::class)

package com.example.full_stack_ktor.model

import io.kvision.types.OffsetDateTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseContextualSerialization

@Serializable
data class ArticlesDto(
    val articles: List<Article>,
    val articlesCount: Int
)

@Serializable
data class Article(
    val id: Int? = null,
    val slug: String? = null,
    val title: String? = null,
    val description: String? = null,
    val body: String? = null,
    val tagList: List<String> = emptyList(),
    val createdAt: OffsetDateTime? = null,
    val updatedAt: OffsetDateTime? = null,
    val favorited: Boolean = false,
    val favoritesCount: Int = 0,
    val author: User? = null,
    val authorId: Int? = null
) {
    constructor(
        id: Int?,
        slug: String?,
        title: String?,
        description: String?,
        body: String?,
        createdAt: OffsetDateTime?,
        updatedAt: OffsetDateTime?,
        authorId: Int?
    ) : this(
        id, slug, title, description, body, emptyList(), createdAt, updatedAt, false, 0, null, authorId
    )
}

@Serializable
data class Comment(
    val id: Int? = null,
    val articleId: Int? = null,
    val createdAt: OffsetDateTime? = null,
    val updatedAt: OffsetDateTime? = null,
    val body: String? = null,
    val author: User? = null,
    val authorId: Int? = null
) {
    constructor(
        id: Int?,
        articleId: Int?,
        createdAt: OffsetDateTime?,
        updatedAt: OffsetDateTime?,
        body: String?,
        authorId: Int?
    ) : this(id, articleId, createdAt, updatedAt, body, null, authorId)
}
