package com.example.full_stack_ktor.views.users

import com.example.full_stack_ktor.ConduitManager
import com.example.full_stack_ktor.ConduitState
import io.kvision.core.Container
import io.kvision.core.onEvent
import io.kvision.form.form
import io.kvision.form.text.TextAreaInput
import io.kvision.form.text.TextInput
import io.kvision.form.text.textAreaInput
import io.kvision.form.text.textInput
import io.kvision.html.*

fun Container.settingsPage(state: ConduitState) {
    div(className = "settings-page") {
        div(className = "container page") {
            div(className = "row") {
                div(className = "col-md-6 offset-md-3 col-xs-12") {
                    h1("Your Settings", className = "text-xs-center")
                    if (!state.settingsErrors.isNullOrEmpty()) {
                        ul(state.settingsErrors, className = "error-messages")
                    }
                    lateinit var imageInput: TextInput
                    lateinit var usernameInput: TextInput
                    lateinit var bioInput: TextAreaInput
                    lateinit var emailInput: TextInput
                    lateinit var passwordInput: TextInput
                    form {
                        fieldset {
                            fieldset(className = "form-group") {
                                imageInput = textInput(value = state.user?.image, className = "form-control") {
                                    placeholder = "URL of profile picture"
                                }
                            }
                            fieldset(className = "form-group") {
                                usernameInput = textInput(
                                    value = state.user?.username,
                                    className = "form-control form-control-lg"
                                ) {
                                    placeholder = "Your Name"
                                }
                            }
                            fieldset(className = "form-group") {
                                bioInput = textAreaInput(
                                    value = state.user?.bio,
                                    rows = 8,
                                    className = "form-control form-control-lg"
                                ) {
                                    placeholder = "Short bio about you"
                                }
                            }
                            fieldset(className = "form-group") {
                                emailInput =
                                    textInput(
                                        InputType.EMAIL,
                                        state.user?.email,
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
                                "Update Settings", type = ButtonType.SUBMIT,
                                className = "btn-lg pull-xs-right"
                            )
                        }
                    }.onEvent {
                        submit = { ev ->
                            ev.preventDefault()
                            ConduitManager.settings(
                                imageInput.value,
                                usernameInput.value,
                                bioInput.value,
                                emailInput.value,
                                passwordInput.value
                            )
                        }
                    }
                    tag(TAG.HR)
                    button("Or click here to logout.", style = ButtonStyle.OUTLINEDANGER).onClick {
                        ConduitManager.logout()
                    }
                }
            }
        }
    }
}
