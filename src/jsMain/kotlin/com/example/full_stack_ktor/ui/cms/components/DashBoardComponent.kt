package com.example.full_stack_ktor.ui.cms.components

import io.kvision.core.Container
import io.kvision.core.onClick
import io.kvision.html.*

data class DashBoardComponentProps(
	val title: String,
	val onClick: () -> Unit
)

fun Container.dashBoardComponent(data : DashBoardComponentProps) {
	div(className = "bg-white shadow-md rounded-lg p-4 flex flex-col items-center justify-center cursor-pointer hover:bg-gray-100 transition") {
		+data.title
	}.onClick {
		data.onClick
	}
}