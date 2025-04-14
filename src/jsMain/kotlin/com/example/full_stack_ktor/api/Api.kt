package com.example.full_stack_ktor.api

import com.example.full_stack_ktor.endpoints.IAuthCheckerEndpointService
import com.example.full_stack_ktor.endpoints.IAuthEndpointService
import com.example.full_stack_ktor.endpoints.IContactEndpointService
import com.example.full_stack_ktor.util.LocalStorageFacade
import io.ktor.client.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.kvision.remote.getService
import kotlinx.serialization.json.Json
import org.koin.dsl.module

const val apiUrl = "http://localhost:8080/api"

val httpClient = HttpClient(Js) {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }

    /*install(Auth) {
        bearer {
            loadTokens {
                val accessToken = LocalStorageFacade.getAccessToken() ?: ""
                BearerTokens(accessToken, "")
            }
            sendWithoutRequest { request ->
                val host = request.url.buildString()
                console.log("About to send credentials along with request")
                console.log("URL: ", host)
                val addAuth = host.startsWith(apiUrl)
                addAuth
            }
        }
    }*/
}

val endpointModule = module {
    single<IAuthEndpointService> {
        getService()
    }
    single<IAuthCheckerEndpointService> {
        getService {
            LocalStorageFacade.getAccessToken()?.let { accessToken ->
                headers["Authorization"] = "Bearer $accessToken"
            }
        }
    }
    single<IContactEndpointService> {
        getService {
            LocalStorageFacade.getAccessToken()?.let { accessToken ->
                headers["Authorization"] = "Bearer $accessToken"
            }
        }
    }
}