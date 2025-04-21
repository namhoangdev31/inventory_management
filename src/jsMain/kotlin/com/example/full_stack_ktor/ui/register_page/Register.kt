package com.example.full_stack_ktor.ui.register_page

import com.example.full_stack_ktor.ui.register_page.viewmodel.RegisterViewModel
import org.koin.dsl.module

val registerModule = module {
    single { RegisterViewModel(get(), get()) }
}