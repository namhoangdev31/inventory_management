package com.example.full_stack_ktor.config

import com.example.full_stack_ktor.controllers.AuthController
import com.example.full_stack_ktor.controllers.UserController
import com.example.full_stack_ktor.exceptions.AuthenticationException
import com.example.full_stack_ktor.models.AuthRequest
import com.example.full_stack_ktor.models.ErrorResponse
import com.example.full_stack_ktor.models.RegisterRequest
import com.example.full_stack_ktor.utils.ApiRoute
import com.example.full_stack_ktor.utils.AppRoute
import com.example.full_stack_ktor.utils.validateAuthRequest
import com.example.full_stack_ktor.utils.validateRegisterRequest
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.freemarker.FreeMarkerContent
import io.ktor.server.plugins.NotFoundException
import io.ktor.server.plugins.doublereceive.DoubleReceive
import io.ktor.server.plugins.requestvalidation.RequestValidation
import io.ktor.server.plugins.requestvalidation.RequestValidationException
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.resources.Resources
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import io.ktor.server.sse.SSE
import io.ktor.server.webjars.Webjars
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.main
import kotlinx.html.p
import kotlinx.html.stream.createHTML
import kotlinx.html.style
import kotlinx.html.title
import kotlinx.html.unsafe

fun Application.configureRouting() {
    install(DoubleReceive)
    install(RequestValidation) {
        validate<RegisterRequest> { registerRequest ->
            validateRegisterRequest(registerRequest)
        }
        validate<AuthRequest> { authRequest ->
            validateAuthRequest(authRequest)
        }
    }
    install(Resources)
    install(SSE)
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
        exception<AuthenticationException> { call, cause ->
            call.respond(
                status = HttpStatusCode.Unauthorized, message = ErrorResponse(
                    statusMessage = HttpStatusCode.Unauthorized.description,
                    error = cause.message ?: "Unauthorized access"
                )
            )
        }
        exception<NotFoundException> { call, cause ->
            call.respond(
                status = HttpStatusCode.NotFound, message = ErrorResponse(
                    statusMessage = HttpStatusCode.NotFound.description,
                    error = cause.message ?: "Resource not found"
                )
            )
        }
        exception<RequestValidationException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("errors" to cause.reasons))
        }
        status(HttpStatusCode.NotFound) { call, _ ->
            call.respond(
                FreeMarkerContent("404.ftl", mapOf("title" to "Page Not Found"))
            )
        }
    }
    install(Webjars) {
        path = "/webjars"
    }
    routing {
        get("/") {
            call.respondText(contentType = ContentType.Text.Html, text = createHTML().html {
                head {
                    title("Ktor & kotlinx-html")
                    style {
                        unsafe {
                            +"body { background-color: #f0f0f0; margin: 0; padding: 0; }"
                            +"h1 { color: #2c3e50; font-family: Arial, sans-serif; }"
                            +"p { font-family: 'Helvetica Neue', sans-serif; font-size: 16px; }"
                        }
                    }
                }
                body {
                    main {
                        style = "text-align: center; padding: 50px;display: flex; flex-direction: column; align-items: center;"
                        div {
                            style = "background-color: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);"
                            h1 { +"Hello, Ktor!" }
                            p { +"This is a simple application using Ktor and kotlinx-html." }
                        }
                    }
                }
            })
        }
        authRoutes(AuthController())
        userRoutes(UserController())
    }
}
//
//post("/double-receive") {
//    val first = call.receiveText()
//    val theSame = call.receiveText()
//    call.respondText(first + " " + theSame)
//}
//get<Articles> { article ->
//    // Get all articles ...
//    call.respond("List of articles sorted starting from ${article.sort}")
//}
//sse("/hello") {
//    send(ServerSentEvent("world"))
//}
//// Static plugin. Try to access `/static/index.html`
//staticResources("/static", "static")
//get("/webjars") {
//    call.respondText("<script src='/webjars/jquery/jquery.js'></script>", ContentType.Text.Html)
//}

fun Route.authRoutes(authController: AuthController) {
    route(ApiRoute.AuthPrefix) {
        get("/${AppRoute.Login}") {
            call.respondText("Display auth page", ContentType.Text.Html)
        }
        post("/${AppRoute.Login}") {
            authController.login(call)
        }
        post("/${AppRoute.Register}") {
            authController.register(call)
        }
    }
}

fun Route.userRoutes(userController: UserController) {
    route("/${AppRoute.User}") {
        get("/") {
            userController.getUser(call)
        }
    }
}
