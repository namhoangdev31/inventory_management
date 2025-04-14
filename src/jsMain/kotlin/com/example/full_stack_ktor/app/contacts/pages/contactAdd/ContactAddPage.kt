package com.example.full_stack_ktor.app.contacts.pages.contactAdd

import com.example.full_stack_ktor.app.contacts.components.ContactFormDto
import com.example.full_stack_ktor.app.contacts.components.contactForm
import com.example.full_stack_ktor.app.layout.mainLayout.mainLayout
import com.example.full_stack_ktor.dto.CreateContactDto
import io.kvision.core.Container
import io.kvision.html.div
import io.kvision.html.h4
import io.kvision.state.bind
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

fun Container.contactAddPage() : KoinComponent = object : KoinComponent {
    private val vm by inject<ContactAddPageViewModel>()

    init {

        mainLayout("Add Contact") {
            div().bind(vm) { pageState ->

                if (pageState.loading) {
                    h4 { +"Loading Information..." }
                }

                contactForm(
                    onError = {
                        vm.trySend(ContactAddPageContract.Inputs.ErrorMessage("One or more fields needs your attention!"))
                    },
                    onSave = {
                        val requestPayload = CreateContactDto(
                            name = it.name,
                            phoneNumbers = it.phoneNumbers.split(","),
                            emails = it.emails.split(","),
                            note = it.note
                        )

                        vm.trySend(ContactAddPageContract.Inputs.CreateContact(requestPayload))
                    }
                )
            }
        }
    }
}