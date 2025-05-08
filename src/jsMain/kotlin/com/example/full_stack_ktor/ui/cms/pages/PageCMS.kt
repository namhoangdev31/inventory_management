package com.example.full_stack_ktor.ui.cms.pages

import com.example.full_stack_ktor.ui.cms.pages.view_model.PagesViewModel
import io.kvision.core.Container
import io.kvision.form.select.Select
import io.kvision.html.*
import io.kvision.panel.HPanel
import io.kvision.state.observableState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module
import kotlin.js.Date

fun Container.pagesCMSView(): KoinComponent = object : KoinComponent {
    val vm by inject<PagesViewModel>()

    init {
        div(className = "container mx-auto p-6 bg-white rounded-lg") {
            div(className = "flex justify-between items-center mb-4 flex-row") {
                h1(className = "text-3xl font-bold text-gray-900 mb-4 md:mb-0") { +"""Pages""" }
                button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm", text = "Create New")
            }
            div(className = "mb-4") {
                input(className = "w-full p-2 border border-gray-300 rounded-md") {
                    type = InputType.TEXT
                    placeholder = "Search by Title"
                }
            }
            div(className = "overflow-x-auto bg-white rounded-lg") {
                table("min-w-full table-auto") {
                    thead(className = "bg-gray-50") {
                        tr {
                            th(className = "p-2 text-left text-sm text-gray-600") { +"""Select""" }
                            th(className = "p-2 text-left text-sm text-gray-600") { +"""Title""" }
                            th(className = "p-2 text-left text-sm text-gray-600") { +"""Slug""" }
                            th(className = "p-2 text-left text-sm text-gray-600") { +"""Updated At""" }
                        }
                    }
                    tbody(className = "divide-y") {
                        console.log("PagesViewModel", vm.observeStates().observableState)
                        vm.observeStates().observableState.subscribe { state ->
                            if (state.listSelect.isNotEmpty()) {
                                state.listSelect.map { e ->
                                    tr(className = "border-t") {
                                        td(className = "p-2") {
                                            input(className = "h-4 w-4 text-blue-500") {
                                                type = InputType.CHECKBOX
                                            }
                                        }
                                        td(className = "p-2 text-sm text-gray-700") { +e.pageName }
                                        td(className = "p-2 text-sm text-gray-500") { +e.pageSlug }
                                        td(className = "p-2 text-sm text-gray-500") { +formatDate(e.updateAt) }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            div(className = "flex flex-col md:flex-row justify-between items-center mt-4") {
                div(className = "flex items-center mb-4 md:mb-0") {
                    span(className = "text-sm text-gray-600") { +"""2 Pages selected —""" }
                    button(className = "text-sm font-medium text-gray-600 ml-2", text = "Select all 3 Pages")
                }
                div(className = "space-x-2 flex justify-center md:justify-start") {
                    button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm", text = "Edit")
                    button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm", text = "Publish")
                    button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm", text = "Unpublish")
                    button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm", text = "Delete")
                }
            }
            div(className = "flex flex-col md:flex-row justify-between items-center mt-4") {
                span(className = "text-sm text-gray-600 mb-4 md:mb-0") { +"""1-3 of 3""" }
//				div(className = "flex items-center space-x-2") {
//					span(className = "text-sm text-gray-600") { +"""Per Page:""" }
//					paginationSelectComponent()
//				}
            }
        }
    }
}

fun paginationSelectComponent(): HPanel {
    val pageSizes = listOf(
        "10" to "10 items",
        "20" to "20 items",
        "50" to "50 items",
        "100" to "100 items"
    )

    val pageSizeSelect = Select(
        options = pageSizes,
        label = "Items per page",
        value = "10",
        selectSize = 4
    )

    val applyButton = Button("Apply").apply {
        onClick {
            val selectedPageSize = pageSizeSelect.value ?: "10"
        }
    }

    return HPanel(spacing = 8).apply {
        add(pageSizeSelect)
        add(applyButton)
    }
}

fun formatDate(timestamp: Double): String {
    val date = Date(timestamp)
    return date.toLocaleString()
}

val pagesModule = module {
    single { PagesViewModel(get(), get()) }
}
