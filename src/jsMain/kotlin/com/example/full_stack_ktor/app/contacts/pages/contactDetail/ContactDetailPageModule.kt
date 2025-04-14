package com.example.full_stack_ktor.app.contacts.pages.contactDetail

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val contactDetailPageModule = module {
    factoryOf(::ContactDetailPageInputHandler)
    factoryOf(::ContactDetailPageEventHandler)
    factoryOf(::ContactDetailPageViewModel)
}