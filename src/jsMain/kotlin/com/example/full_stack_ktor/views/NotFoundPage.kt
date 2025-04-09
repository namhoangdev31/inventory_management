package com.example.full_stack_ktor.views

import io.kvision.core.AlignItems
import io.kvision.html.*
import io.kvision.panel.SimplePanel
import io.kvision.utils.px

class NotFoundPage : SimplePanel() {
    init {
        alignItems = AlignItems.CENTER
        marginTop = 100.px
        h1("❌ 404 - Không tìm thấy trang")
        p("Vui lòng kiểm tra lại đường dẫn hoặc quay lại trang chủ.")
    }
}