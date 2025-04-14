package com.example.full_stack_ktor.app.auth.pages.register

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val signupPageModule = module {
    factoryOf(::SignupPageInputHandler)
    factoryOf(::SignupPageEventHandler)
    factoryOf(::SignupPageViewModel)
}