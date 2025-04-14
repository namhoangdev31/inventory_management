package com.example.full_stack_ktor.app.layout.shared

import com.example.full_stack_ktor.app.layout.shared.appHeader.appHeaderModule
import org.koin.dsl.module

val sharedComponentsModule = module {
    includes(appHeaderModule)
}