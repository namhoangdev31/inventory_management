package com.example.full_stack_ktor.ui.login_page.presentation

import com.example.full_stack_ktor.ui.login_page.viewmodel.*
import io.kvision.core.Container
import io.kvision.core.onClick
import io.kvision.form.formPanel
import io.kvision.form.text.Password
import io.kvision.form.text.Text
import io.kvision.html.*
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
		val loginForm = formPanel<LoginFormDto> {
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
		
		main(className = "d-flex justify-content-center align-items-center vh-100 bg-light") {
			div(className = "flex-1 d-flex flex-column justify-content-center align-items-center") {
				image(src = "https://example.com/logo.png", alt = "Logo", className = "mb-4")
			}
			div(className = "flex-1 d-flex flex-column justify-content-center align-items-center") {
				// Form panel to handle data binding and submission
				loginForm.apply {
					// Adding submit button
					button(type = ButtonType.SUBMIT, text = "Login", className = "btn btn-primary")
				}.onClick {
					val map = form.getData()
				}
			}
		}
	}
}
