package com.example.full_stack_ktor.share_components

import io.kvision.core.Container
import io.kvision.html.*

fun Container.notFoundPage() {
    div(className = "flex min-h-screen flex-col items-center justify-center bg-white px-4 text-center") {
        +"""<!-- 404 Section -->"""
        div(className = "relative flex items-center justify-center text-9xl leading-none font-extrabold tracking-wider text-blue-100") {
            span { +"""4""" }
            span(className = "relative mx-4") {
                span(className = "magnifier absolute inset-0 z-10 m-auto") {
                }
                span(className = "relative z-0 text-blue-100") { +"""0""" }
            }
            span { +"""4""" }
        }
        +"""<!-- Message -->"""
        p(className = "mt-8 text-lg text-gray-500 text-center") { +"""The page you’re looking for can’t be found.""" }
        +"""<!-- Button -->"""
        a(className =  " mt-6 inline-block rounded-md bg-gradient-to-r from-blue-500 to-cyan-400 px-6 py-3 font-medium text-white transition hover:from-blue-600 hover:to-cyan-500" , href = "/") {
            +"""Back to Homepage"""
        }
    }
}