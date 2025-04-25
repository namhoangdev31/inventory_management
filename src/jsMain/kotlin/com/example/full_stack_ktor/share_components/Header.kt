package com.example.full_stack_ktor.share_components

import com.example.full_stack_ktor.app.AppRouter
import com.example.full_stack_ktor.ui.cms.headerCMSComponent
import io.kvision.core.Container
import io.kvision.html.*

fun Container.headerMasterComponent(router: AppRouter) {
	when (router) {
		AppRouter.CMSAdmin -> headerCMSComponent()
		AppRouter.CMSPage -> headerCMSComponent()
		else -> {
			div(className = "hidden")
		}
	}
}