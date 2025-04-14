package com.example.full_stack_ktor.app.contacts.pages

import com.example.full_stack_ktor.app.contacts.pages.contactAdd.contactAddPageModule
import com.example.full_stack_ktor.app.contacts.pages.contactDetail.contactDetailPageModule
import com.example.full_stack_ktor.app.contacts.pages.contactList.contactListPageModule
import org.koin.dsl.module

val contactModule = module {
    includes(contactListPageModule, contactAddPageModule, contactDetailPageModule)
}