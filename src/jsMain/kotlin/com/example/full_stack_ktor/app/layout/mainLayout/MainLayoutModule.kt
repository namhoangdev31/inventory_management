package com.example.full_stack_ktor.app.layout.mainLayout

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val mainLayoutModule = module {
    singleOf(::MainLayoutEventHandler)
    singleOf(::MainLayoutInputHandler)
    singleOf(::MainLayoutViewModel)
}