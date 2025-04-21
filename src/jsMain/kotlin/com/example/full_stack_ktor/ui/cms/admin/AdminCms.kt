package com.example.full_stack_ktor.ui.cms.admin

import io.kvision.core.Container
import io.kvision.core.onInput
import io.kvision.html.*
import io.kvision.form.text.TextArea

fun Container.adminCmsPage() {
    val inputArea = TextArea(
        rows = 30
    )
    val previewArea = Div(
        className = "w-full h-full border p-4 bg-gray-50 overflow-auto"
    )

    div(className = "flex h-screen p-4") {
        div(className = "w-1/2 h-full") {
            add(inputArea)
        }
        div(className = "w-1/2 h-full") {
            add(previewArea)
        }
    }

    inputArea.onInput {
        previewArea.getElement()?.innerHTML = inputArea.value ?: ""
    }

    val defaultHtml = """
        <div class="p-6 bg-white rounded-lg shadow-md">
            <h1 class="text-2xl font-bold text-indigo-600">Hello Tailwind!</h1>
            <p class="text-gray-600 mt-2">This is a preview box styled with Tailwind classes.</p>
            <button class="mt-4 px-4 py-2 bg-indigo-600 text-white rounded hover:bg-indigo-500">Click Me</button>
        </div>
    """.trimIndent()

    inputArea.value = defaultHtml
    previewArea.getElement()?.innerHTML = defaultHtml
}

