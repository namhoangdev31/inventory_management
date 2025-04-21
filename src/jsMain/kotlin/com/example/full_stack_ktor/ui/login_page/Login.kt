package com.example.full_stack_ktor.ui.login_page

import com.example.full_stack_ktor.ui.login_page.viewmodel.LoginViewModel
import org.koin.dsl.module

val loginModule = module {
    single { LoginViewModel(get(), get()) }
}