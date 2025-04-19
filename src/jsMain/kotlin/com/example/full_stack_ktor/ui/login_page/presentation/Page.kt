package com.example.full_stack_ktor.ui.login_page.presentation

import com.example.full_stack_ktor.ui.login_page.viewmodel.LoginViewModel
import io.kvision.core.Container
import io.kvision.form.formPanel
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.html.InputType
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.image
import io.kvision.html.input
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
    private val loginForm = formPanel<LoginFormDto>(className="bg-white p-8 rounded-lg shadow-lg w-96 mx-auto mt-10") {
        add(
            LoginFormDto::email,
            Text(label = "Email", type = InputType.EMAIL) {
                placeholder = "Login Email..."
            },
            required = true
        )
        add(
            LoginFormDto::password,
            Password(label = "Password" ) {
                placeholder = "Login Password..."
            },
            required = true
        )
    }.apply {
        this.input(className = "orm-control border border-gray-300 rounded-lg p-3 w-full mb-4") {}
    }
    init {
        div(className = "flex justify-center items-center h-screen bg-gray-100 p-12") {
            div(className = "flex-1 p-24 flex justify-center items-center") {
                image(
                    src = "https://cdn11.dienmaycholon.vn/filewebdmclnew/public/userupload/files/Image%20FP_2024/avatar-cute-3.jpg",
                    alt = "Logo",
                    className = "mx-auto max-w-50 max-h-50 object-cover"
                )
            }
            div(className = "flex-1") {
                this.add(loginForm)
                button(className = "btn btn-primary" , text = "Login") {
                    onClick {
                       val loginValue = loginForm.getData()
                        console.log(loginValue)
                    }
                }
            }
        }
    }
}
