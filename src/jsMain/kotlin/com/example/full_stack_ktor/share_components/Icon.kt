package com.example.full_stack_ktor.share_components

import io.kvision.core.Container
import io.kvision.html.TAG
import io.kvision.html.Tag
import kotlin.String

open class IconApp(className: String? = null , init: (IconApp.() -> Unit)? = null ) : Tag(TAG.I ,className) {
	init {
		@Suppress("LeakingThis")
		init?.invoke(this)
	}
}

fun Container.iconApp(
	className: String = "text-gray-500 hover:text-gray-700",
	function: () -> Unit
):IconApp  {
	return IconApp(className)
}