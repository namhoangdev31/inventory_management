package com.example.full_stack_ktor.app.contacts.pages.contactAdd

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val contactAddPageModule = module {
    factoryOf(::ContactAddPageInputHandler)
    factoryOf(::ContactAddPageEventHandler)
    factoryOf(::ContactAddPageViewModel)
}