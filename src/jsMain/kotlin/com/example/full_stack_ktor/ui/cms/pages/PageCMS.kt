package com.example.full_stack_ktor.ui.cms.pages

import com.example.full_stack_ktor.ui.cms.login.viewmodel.LoginCMSViewModel
import com.example.full_stack_ktor.ui.cms.pages.view_model.PagesViewModel
import io.kvision.core.Container
import io.kvision.form.select.Select
import io.kvision.form.select.select
import org.koin.core.component.KoinComponent
import io.kvision.html.*
import org.koin.core.component.inject
import org.koin.dsl.module

fun Container.pagesCMSView(): KoinComponent = object : KoinComponent {
    val pagesViewModel by inject<PagesViewModel>()

    init {
        div(className = "container mx-auto p-6 bg-white shadow-md rounded-lg") {
            div(className = "flex justify-between items-center mb-4 flex-row") {
                h1(className = "text-3xl font-bold text-gray-900 mb-4 md:mb-0") { +"""Pages""" }
                button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm" , text = "Create New")
            }
            div(className = "mb-4") {
                input(className = "w-full p-2 border border-gray-300 rounded-md") {
                    type = InputType.TEXT
                    placeholder = "Search by Title"
                }
            }
            div(className = "overflow-x-auto bg-white rounded-lg shadow-md") {
                table("min-w-full table-auto") {
                    thead {
                        tr {
                            th(className = "p-2 text-left text-sm text-gray-600") { +"""Select""" }
                            th(className = "p-2 text-left text-sm text-gray-600") { +"""Title""" }
                            th(className = "p-2 text-left text-sm text-gray-600") { +"""Slug""" }
                            th(className = "p-2 text-left text-sm text-gray-600") { +"""Updated At""" }
                        }
                    }
                    tbody {
                        tr(className = "border-t") {
                            td(className = "p-2") {
                                input(className = "h-5 w-5 text-indigo-600 focus:ring-indigo-500") {
                                    type = InputType.CHECKBOX
                                }
                            }
                            td(className = "p-2 text-sm text-gray-700") { +"""Cart""" }
                            td(className = "p-2 text-sm text-gray-500") { +"""cart""" }
                            td(className = "p-2 text-sm text-gray-500") { +"""April 23rd 2025, 9:36 AM""" }
                        }
                        tr(className = "border-t") {
                            td(className = "p-2") {
                                input(className = "h-5 w-5 text-indigo-600 focus:ring-indigo-500") {
                                    type = InputType.CHECKBOX
                                    checked = true
                                }
                            }
                            td(className = "p-2 text-sm text-gray-700") { +"""Home""" }
                            td(className = "p-2 text-sm text-gray-500") { +"""home""" }
                            td(className = "p-2 text-sm text-gray-500") { +"""April 23rd 2025, 9:36 AM""" }
                        }
                        tr(className = "border-t") {
                            td(className = "p-2") {
                                input(className = "h-5 w-5 text-indigo-600 focus:ring-indigo-500") {
                                    type = InputType.CHECKBOX
                                    checked =true
                                }
                            }
                            td(className = "p-2 text-sm text-gray-700") { +"""Products""" }
                            td(className = "p-2 text-sm text-gray-500") { +"""products""" }
                            td(className = "p-2 text-sm text-gray-500") { +"""April 23rd 2025, 9:36 AM""" }
                        }
                    }
                }
            }
            div(className = "flex flex-col md:flex-row justify-between items-center mt-4") {
                div(className = "flex items-center mb-4 md:mb-0") {
                    span("text-sm text-gray-600") { +"""2 Pages selected —""" }
                    button(className = "text-sm font-medium text-gray-600 ml-2" , text = "Select all 3 Pages")
                }
                div(className = "space-x-2 flex justify-center md:justify-start") {
                    button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm" , text = "Edit")
                    button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm" , text = "Publish")
                    button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm" , text = "Unpublish")
                    button(className = "px-4 py-2 border border-gray-300 rounded-md text-sm" , text = "Delete")
                }
            }
            div(className = "flex flex-col md:flex-row justify-between items-center mt-4") {
                span(className="text-sm text-gray-600 mb-4 md:mb-0") { +"""1-3 of 3""" }
                div(className = "flex items-center space-x-2") {
                    span(className = "text-sm text-gray-600") { +"""Per Page:""" }
                    paginationSelectComponent()
                }
            }
        }
    }
}

fun Container.paginationSelectComponent() {
    // Các tùy chọn cho Select (số mục trên mỗi trang)
    val pageSizes = listOf(
        "10" to "10 items",
        "20" to "20 items",
        "50" to "50 items",
        "100" to "100 items"
    )

    // Tạo Select để chọn số mục mỗi trang
    val pageSizeSelect = Select(
        options = pageSizes,
        label = "Items per page",
        value = "10", // Giá trị mặc định là 10
        selectSize = 4
    )

    // Nút Apply để áp dụng phân trang
    val applyButton = Button("Apply").apply {
        onClick {
            val selectedPageSize = pageSizeSelect.value ?: "10"
        }
    }

    // Thêm vào container
    this.add(pageSizeSelect)
    this.add(applyButton)
}

val pagesModule = module {
    single { PagesViewModel(get(), get()) }
}