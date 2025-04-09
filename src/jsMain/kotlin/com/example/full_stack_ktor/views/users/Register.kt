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

fun Container.registerPage(state: ConduitState) {
    div(className = "auth-page") {
        div(className = "container page") {
            div(className = "row") {
                div(className = "col-md-6 offset-md-3 col-xs-12") {
                    h1("Sign up", className = "text-xs-center")
                    p(className = "text-xs-center") {
                        link("Have an account?", "${View.LOGIN.url}")
                    }
                    if (!state.registerErrors.isNullOrEmpty()) {
                        ul(state.registerErrors, className = "error-messages")
                    }
                    lateinit var usernameInput: TextInput
                    lateinit var emailInput: TextInput
                    lateinit var passwordInput: TextInput
                    form {
                        fieldset(className = "form-group") {
                            usernameInput =
                                textInput(value = state.registerUserName, className = "form-control form-control-lg") {
                                    placeholder = "Your Name"
                                }
                        }
                        fieldset(className = "form-group") {
                            emailInput =
                                textInput(
                                    InputType.EMAIL,
                                    state.registerEmail,
                                    className = "form-control form-control-lg"
                                ) {
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
                            "Sign up",
                            type = ButtonType.SUBMIT,
                            className = "btn-lg pull-xs-right"
                        )
                    }.onEvent {
                        submit = { ev ->
                            ev.preventDefault()
                            ConduitManager.register(usernameInput.value, emailInput.value, passwordInput.value)
                        }
                    }
                }
            }
        }
    }
}
