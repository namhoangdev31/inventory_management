package com.example.full_stack_ktor.ui.super_admin

import com.example.full_stack_ktor.share_components.a
import com.example.full_stack_ktor.ui.cms.login.viewmodel.LoginCMSContract
import com.example.full_stack_ktor.ui.cms.login.viewmodel.LoginCMSViewModel
import com.example.full_stack_ktor.ui.super_admin.viewmodel.SuperAdminContract
import com.example.full_stack_ktor.ui.super_admin.viewmodel.SuperAdminViewModel
import io.kvision.core.Container
import io.kvision.core.onChange
import io.kvision.html.ButtonType
import io.kvision.html.InputType
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.h1
import io.kvision.html.image
import io.kvision.html.input
import io.kvision.html.label
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module
import kotlin.getValue

fun Container.superAdmin(): KoinComponent = object : KoinComponent {
    val superAdminViewModel by inject<SuperAdminViewModel>()
    init {
        div(className = "min-h-screen flex items-center justify-center bg-gray-50") {
            div(className = "w-full max-w-sm bg-white p-8 rounded-lg shadow-md") {

                // Logo + CMS Name
                div(className = "mb-6 text-center") {
                    image(src = "images/logo.png", className = "h-10 mx-auto mb-2")
                    h1(className = "text-xl font-semibold text-gray-800") { +"Super Admin" }
                }

                // Email Field
                div(className = "mb-4") {
                    label(className = "block text-sm font-medium text-gray-700 mb-1") {
                        +"Username"
                    }
                    input(className = "w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500") {
                        placeholder = "you@example.com"
                        type = InputType.TEXT
                        onChange { event ->
                            val email = event.target?.asDynamic()?.value?.toString() ?: ""
                            superAdminViewModel.trySend(
                                SuperAdminContract.Inputs.UpdateUsername(email)
                            )
                        }
                    }
                }

                // Password Field
                div(className = "mb-4") {
                    label(className = "block text-sm font-medium text-gray-700 mb-1") {
                        +"Password"
                    }
                    input(className = "w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-indigo-500") {
                        placeholder = "••••••••"
                        type = InputType.PASSWORD
                        onChange { event ->
                            val password = event.target?.asDynamic()?.value?.toString() ?: ""
                            superAdminViewModel.trySend(
                                SuperAdminContract.Inputs.UpdatePassword(password)
                            )
                        }
                    }
                }

                // Forgot password link
                div(className = "text-right mb-4") {
                    a(
                        href = "#",
                        className = "text-sm text-indigo-600 hover:underline",
                        label = "Forgot your password?"
                    )
                }

                // Login Button
                button(
                    type = ButtonType.BUTTON,
                    className = "w-full py-2 px-4 bg-indigo-600 text-white font-semibold rounded-md hover:bg-indigo-500 transition duration-150",
                    text = "Log in"
                ).onClick {
                    superAdminViewModel.trySend(SuperAdminContract.Inputs.Login)
                }
            }
        }
    }
}


val superAdminViewModel = module {
    single { SuperAdminViewModel(get(), get()) }
}