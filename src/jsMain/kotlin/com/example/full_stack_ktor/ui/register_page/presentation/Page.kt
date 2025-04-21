package com.example.full_stack_ktor.ui.register_page.presentation

import com.example.full_stack_ktor.ui.register_page.viewmodel.RegisterContract
import com.example.full_stack_ktor.ui.register_page.viewmodel.RegisterViewModel
import io.kvision.core.Container
import io.kvision.form.form
import io.kvision.html.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

fun Container.registerPage(): KoinComponent = object : KoinComponent {
    private val registerViewModel by inject<RegisterViewModel>()

    init {
        div(className = "relative flex flex-row p-8 gap-4 min-h-screen justify-center items-center min-w-full") {
            div(className = "flex-1 md:flex hidden justify-center items-center") {
                image(
                    className = "object-contain h-auto rounded-lg shadow-lg",
                    src = "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg"
                ) {
                    alt = "Image"
                }
            }
            div(className = "flex-1 flex justify-center items-center") {
                div(className = "w-full max-w-md bg-white p-8") {
                    div(className = "text-center mb-6") {
                        image(
                            className = "mx-auto h-16 w-16 rounded-xl mb-4",
                            src = "https://d1hjkbq40fs2x4.cloudfront.net/2016-01-31/files/1045.jpg"
                        ) {
                            alt = "Logo"
                        }
                        h2(className = "text-2xl font-semibold mt-4 mb-2") { +"""Create an account""" }
                        p(className = "text-gray-500 mb-4") { +"""Start your 30-day free trial.""" }
                    }
                    form {
                        div(className = "mb-4") {
                            input(className = "w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500") {
                                type = InputType.TEXT
                                placeholder = "Enter your name"
                            }
                        }
                        div(className = "mb-4") {
                            input(className = "w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500") {
                                type = InputType.EMAIL
                                placeholder = "Enter your email"
                            }
                        }
                        div(className = "mb-4") {
                            input(className = "w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500") {
                                type = InputType.PASSWORD
                                placeholder = "Create a password"
                            }
                            p(className = "text-sm text-gray-500 mt-2") { +"""Password must be at least 8 characters long.""" }
                        }
                        div(className = "mb-4") {
                            input(className = "w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500") {
                                type = InputType.PASSWORD
                                placeholder = "Re-enter your password"
                            }
                            p(className = "text-sm text-gray-500 mt-2") { +"""Please re-enter the same password to confirm.""" }
                        }
                        div(className = "flex items-center justify-between mb-4") {
                            label(className = "flex items-center text-sm") {
                                input(className = "mr-2") {
                                    type = InputType.CHECKBOX
                                }
                                +"""Remember for 30 days"""
                            }
                            link(className = "text-blue-500 text-sm", label = "Forgot password?") {
                                url = "#"
                            }
                        }
                        div(className = "mb-4") {
                            button(className = "w-full bg-blue-500 text-white p-3 rounded-lg", text = "Get started") {
                                type = ButtonType.BUTTON
                            }
                        }
                        div(className = "mb-4 text-center") {
                            button(
                                className = "w-full bg-red-500 text-white p-3 rounded-lg",
                                text = "Sign up with Google"
                            ) {
                                type = ButtonType.BUTTON
                            }
                        }
                        div(className = "text-center") {
                            p(className = "text-sm") {
                                +"""Already have an account?"""
                                link(className = "text-blue-500", label = "Log in") {
                                    url = "/login"
                                    onClick { event ->
                                        registerViewModel.trySend(
                                            RegisterContract.Inputs.GoBack
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}