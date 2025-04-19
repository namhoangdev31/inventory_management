package com.example.full_stack_ktor.ui.login_page.presentation

import com.example.full_stack_ktor.ui.login_page.viewmodel.LoginContract
import com.example.full_stack_ktor.ui.login_page.viewmodel.LoginViewModel
import io.kvision.core.Container
import io.kvision.core.onChange
import io.kvision.form.FormMethod
import io.kvision.form.form
import io.kvision.html.*
import io.kvision.state.bind
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Serializable
data class LoginFormDto(
    val email: String = "",
    val password: String = ""
)

fun Container.loginPage(): KoinComponent = object : KoinComponent {
    private val loginViewModel by inject<LoginViewModel>()
    init {
        div(className = "relative flex flex-row p-8 gap-4 min-h-screen justify-center items-center min-w-full") {
            div(className = "flex-1 md:flex hidden justify-center items-center") {
                image(
                    className = "object-contain h-auto rounded-xl",
                    src = "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg"
                ) {
                    alt = "Image"
                }
            }
            div(className = "flex-1 flex justify-center items-center") {
                div(className = "w-full max-w-md bg-white p-8") {
                    div(className = "text-center mb-6") {
                        image(
                            className = "mx-auto h-16 w-16 rounded-xl",
                            src = "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg"
                        ) {
                            alt = "Logo"
                        }
                        h2(className = "text-2xl font-semibold mt-4") { +"""Log in to your account""" }
                        p(className = "text-gray-500") { +"""Welcome back! Please enter your details.""" }
                    }
                    form {
                        div(className = "mb-4") {
                            input(className = "w-full p-2 border border-gray-300 rounded-lg").apply {
                                type = InputType.EMAIL
                                placeholder = "Enter your email"
                                onChange { event ->
                                    val email = event.target?.asDynamic()?.value?.toString() ?: ""
                                    loginViewModel.trySend(
                                        LoginContract.Inputs.UpdateEmail(email)
                                    )
                                }
                            }
                        }
                        div(className = "mb-4") {
                            input(className = "w-full p-2 border border-gray-300 rounded-lg") {
                                type = InputType.PASSWORD
                                placeholder = "Enter your password"
                                onChange { event ->
                                    val password = event.target?.asDynamic()?.value?.toString() ?: ""
                                    loginViewModel.trySend(
                                        LoginContract.Inputs.UpdatePassword(password)
                                    )
                                }
                            }
                        }
                        div(className = "flex items-center justify-between mb-4") {
                            label(className = "flex items-center text-sm") {
                                input(className = "mr-2") {
                                    type = InputType.CHECKBOX
                                }
                                +"""Remember for 30 days"""
                            }
                            link(
                                className = "text-blue-500 text-sm",
                                label = "Forgot password?",
                            ) {
                                target = "_blank"
                                url = "https://www.google.com"
                            }
                        }
                        div(className = "mb-4") {
                            button(className = "w-full bg-blue-500 text-white p-3 rounded-lg", text = "Sign In") {
                                type = ButtonType.BUTTON
                            }.onClick {
                                loginViewModel.trySend(
                                    LoginContract.Inputs.Submit(
                                        email = loginViewModel.observeStates().value.email,
                                        password = loginViewModel.observeStates().value.password
                                    )
                                )
                            }
                        }
                        div(className = "mb-4 text-center") {
                            button(
                                className = "w-full bg-red-500 text-white p-3 rounded-lg",
                                text = "Sign in with Google"
                            ) {
                                type = ButtonType.BUTTON
                            }.onClick {
                                loginViewModel.trySend(
                                    LoginContract.Inputs.Submit(
                                        email = loginViewModel.observeStates().value.email,
                                        password = loginViewModel.observeStates().value.password
                                    )
                                )
                            }
                        }
                        div(className = "text-center") {
                            p(className = "text-sm") {
                                +"""Don't have an account?"""
                                link(className = "text-blue-500", label = "Sign Up") {
                                    url = "https://www.google.com"
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
