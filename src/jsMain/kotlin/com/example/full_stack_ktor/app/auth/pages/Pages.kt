package com.example.full_stack_ktor.app.auth.pages

import com.example.full_stack_ktor.app.auth.pages.login.loginPageModule
import com.example.full_stack_ktor.app.auth.pages.register.signupPageModule
import org.koin.dsl.module

val authModule = module {
    includes(loginPageModule, signupPageModule)
}