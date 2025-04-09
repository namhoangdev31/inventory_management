package com.example.full_stack_ktor.views.users

import com.example.full_stack_ktor.ConduitManager
import com.example.full_stack_ktor.ConduitState
import com.example.full_stack_ktor.View
import io.kvision.core.Container
import io.kvision.core.onEvent
import io.kvision.form.form
import io.kvision.form.text.TextInput
import io.kvision.form.text.textInput
import io.kvision.html.*

fun Container.loginPage(state: ConduitState) {
    div(className = "auth-page") {
        div(className = "container page") {
            div(className = "row") {
                div(className = "col-md-6 offset-md-3 col-xs-12") {
                    h1("Sign in", className = "text-xs-center")
                    p(className = "text-xs-center") {
                        link("Need an account?", "${View.REGISTER.url}")
                    }
                    if (!state.loginErrors.isNullOrEmpty()) {
                        ul(state.loginErrors, className = "error-messages")
                    }
                    lateinit var emailInput: TextInput
                    lateinit var passwordInput: TextInput
                    form {
                        fieldset(className = "form-group") {
                            emailInput =
                                textInput(type = InputType.EMAIL, className = "form-control form-control-lg") {
                                    placeholder = "Email"
                                }
                        }
                        fieldset(className = "form-group") {
                            passwordInput =
                                textInput(InputType.PASSWORD, className = "form-control form-control-lg") {
                                    placeholder = "Password"
                                }
                        }
                        button(
                            "Sign in",
                            type = ButtonType.SUBMIT,
                            className = "btn-lg pull-xs-right"
                        )
                    }.onEvent {
                        submit = { ev ->
                            ev.preventDefault()
                            ConduitManager.login(emailInput.value, passwordInput.value)
                        }
                    }
                }
            }
        }
    }
}
