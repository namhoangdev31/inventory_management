package com.example.full_stack_ktor.ui.cms.login

import com.example.full_stack_ktor.ui.cms.login.viewmodel.LoginCMSViewModel
import io.kvision.core.Container
import org.koin.dsl.module

fun Container.loginCMSAdminPage(){

}

val loginCMSViewModel = module {
	single { LoginCMSViewModel(get(), get()) }
}