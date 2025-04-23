package com.example.full_stack_ktor.share_components

import com.example.full_stack_ktor.app.AppRouter
import com.example.full_stack_ktor.ui.cms.footerCMSComponent
import io.kvision.core.Container
import io.kvision.html.*

fun Container.footerMasterComponent(router: AppRouter) {
	when (router) {
		AppRouter.CMSAdmin -> footerCMSComponent()
		else -> {
			div(className = "hidden")
		}
	}
}