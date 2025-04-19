package com.example.full_stack_ktor.ui.login_page.presentation

import com.example.full_stack_ktor.ui.login_page.viewmodel.LoginViewModel
import io.kvision.core.Container
import io.kvision.form.formPanel
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.html.InputType
import io.kvision.html.div
import io.kvision.html.image
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
        div(className = "flex justify-center items-center h-screen bg-gray-100 p-12") {
            div(className = "flex-1 p-12 flex justify-center items-center") {
                image(
                    src = "https://cdn11.dienmaycholon.vn/filewebdmclnew/public/userupload/files/Image%20FP_2024/avatar-cute-3.jpg",
                    alt = "Logo",
                    className = "mx-auto w-40 h-40 object-cover"
                )
            }
            div(className = "flex-1 p-12") {
                formPanel<LoginFormDto> {
                    add(
                        LoginFormDto::email,
                        Text(label = "Email", type = InputType.EMAIL) {
                            placeholder = "Login Email..."
                        },
                        required = true
                    )
                    add(
                        LoginFormDto::password,
                        Password(label = "Password") {
                            placeholder = "Login Password..."
                        },
                        required = true
                    )
                }
            }
        }
    }
}
