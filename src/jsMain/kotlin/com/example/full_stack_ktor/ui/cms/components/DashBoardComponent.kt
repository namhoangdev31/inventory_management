package com.example.full_stack_ktor.ui.cms.components

import com.example.full_stack_ktor.share_components.iconApp
import io.kvision.core.AlignItems
import io.kvision.core.Container
import io.kvision.core.onClick
import io.kvision.html.*
import io.kvision.maps.externals.leaflet.dom.DomUtil.addClass
import io.kvision.utils.px
import io.kvision.utils.rem

data class DashBoardComponentProps(
	val title: String,
	val onClick: () -> Unit
)


fun Container.dashBoardComponent(data: DashBoardComponentProps) {
	val textStyle = "flex bg-white shadow-md hover:shadow-lg text-center md:text-left rounded-lg group hover:bg-blue-500 hover:text-white items-center md:items-start md:justify-center gap-4 w-full p-6 cursor-pointer md:flex-col flex-row justify-between"

	div(className = textStyle) {
		div(className = "md:text-2xl font-medium text-lg") {
			+data.title
		}
		icon("bi bi-plus-square-fill text-gray-200 group-hover:text-white rounded-lg") {
			width = 1.5.rem
			height = 1.5.rem
			alignItems = AlignItems.CENTER
		}
	}.onClick {
		data.onClick()
	}
}