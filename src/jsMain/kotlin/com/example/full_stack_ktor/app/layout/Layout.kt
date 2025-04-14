package com.example.full_stack_ktor.app.layout

import com.example.full_stack_ktor.app.layout.mainLayout.mainLayoutModule
import org.koin.dsl.module

val appLayoutModule = module {
    includes(mainLayoutModule)
}