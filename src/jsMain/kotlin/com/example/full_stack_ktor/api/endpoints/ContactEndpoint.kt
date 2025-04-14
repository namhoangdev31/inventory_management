package com.example.full_stack_ktor.api.endpoints

import arrow.core.Either
import com.example.full_stack_ktor.api.apiUrl
import com.example.full_stack_ktor.api.httpClient
import com.example.full_stack_ktor.dto.*
import com.example.full_stack_ktor.endpoints.IContactEndpointService
import com.example.full_stack_ktor.error.ApiError
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

/*
object ContactEndpointServiceImpl : IContactEndpointService {
    private val baseUrl = "$apiUrl/contacts"

    override suspend fun list(): Either<ApiError, ApiDataResource<List<ContactDto>>> {
        return Either.catch {
            val apiResponse: ApiDataResource<List<ContactDto>> = httpClient.get {
                url("$baseUrl/list")
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
            }.body()
            apiResponse
        }.mapLeft {
            ApiError.GenericError(it.message!!)
        }
    }

    override suspend fun findByUid(uid: String): Either<ApiError, ApiDataResource<ContactDto>> {
        return Either.catch {
            val apiResponse: ApiDataResource<ContactDto> = httpClient.get {
                url("$baseUrl/find/uid/$uid")
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
            }.body()
            apiResponse
        }.mapLeft {
            ApiError.GenericError(it.message!!)
        }
    }

    override suspend fun create(data: CreateContactDto): Either<ApiError, ApiDataResource<EntityUid>> {
        return Either.catch {
            val apiResponse: ApiDataResource<EntityUid> = httpClient.post {
                url("$baseUrl/create")
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
                setBody(data)
            }.body()
            apiResponse
        }.mapLeft {
            ApiError.GenericError(it.message!!)
        }
    }

    override suspend fun update(uid: String, data: UpdateContactDto): Either<ApiError, ApiDataResource<EntityUid>> {
        return Either.catch {
            val apiResponse: ApiDataResource<EntityUid> = httpClient.patch {
                url("$baseUrl/update/$uid")
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
                setBody(data)
            }.body()
            apiResponse
        }.mapLeft {
            ApiError.GenericError(it.message!!)
        }
    }

    override suspend fun delete(uid: String): Either<ApiError, ApiDataResource<EntityUid>> {
        return Either.catch {
            val apiResponse: ApiDataResource<EntityUid> = httpClient.delete {
                url("$baseUrl/delete/$uid")
                accept(ContentType.Application.Json)
                contentType(ContentType.Application.Json)
            }.body()
            apiResponse
        }.mapLeft {
            ApiError.GenericError(it.message!!)
        }
    }
}*/
