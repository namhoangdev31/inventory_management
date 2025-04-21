package com.example.full_stack_ktor.ui.home_page.presentation

import com.example.full_stack_ktor.share_components.a
import com.example.full_stack_ktor.share_components.img
import io.kvision.core.Container
import io.kvision.form.form
import io.kvision.html.*
import org.koin.core.component.KoinComponent

fun Container.homePage(): KoinComponent = object : KoinComponent {
    init {
        header(className = "bg-white shadow") {
            div(className = "container mx-auto px-6 py-4 flex justify-between items-center") {
                a(
                    className = "text-2xl font-bold text-indigo-600", label = "Estatery",
                    href = "/"
                )
                nav(className = "space-x-6 hidden md:flex") {
                    a(className = "hover:text-indigo-600", label = "Rent", href = "/")
                    a(className = "hover:text-indigo-600", label = "Buy", href = "/")
                    a(className = "hover:text-indigo-600", label = "Sell", href = "/")
                    div(className = "relative group inline-block") {
                        button(className = "hover:text-indigo-600 focus:outline-none", text = "Manage Property")
                    }
                    div(className = "relative group inline-block") {
                        button(className = "hover:text-indigo-600 focus:outline-none", text = "Resources")
                    }
                }
                div(className = "space-x-4") {
                    a(className = "text-gray-600 hover:text-gray-800", label = "Login", href = "/login")
                    a(className = "px-4 py-2 bg-indigo-600 text-white rounded hover:bg-indigo-500", href = "/signup") {
                        +"""Sign up"""
                    }
                }
            }
        }
        section(className = "bg-gradient-to-tr from-indigo-50 to-white") {
            div(className = "container mx-auto px-6 py-20 grid grid-cols-1 md:grid-cols-2 gap-8 items-center") {
                div {
                    h1(className = "text-4xl md:text-5xl font-extrabold mb-4") { +"""Buy, rent, or sell your property easily""" }
                    p(className = "text-gray-600 mb-6") { +"""a(className = "" )great platform to buy, sell, or even rent your properties without any commissions.""" }
                    div(className = "bg-white shadow rounded-lg p-1 inline-flex mb-6") {
                        button(
                            className = "px-6 py-2 text-sm font-medium text-indigo-700 bg-indigo-100 rounded-lg",
                            text = "Rent"
                        )
                        button(
                            className = "px-6 py-2 text-sm font-medium text-gray-600 hover:text-indigo-700",
                            text = "Buy"
                        )
                        button(
                            className = "px-6 py-2 text-sm font-medium text-gray-600 hover:text-indigo-700",
                            text = "Sell"
                        )
                    }
                    form(className = "flex flex-col sm:flex-row bg-white rounded-lg shadow overflow-hidden") {
                        input(className = "flex-1 p-4 focus:outline-none") {
                            type = InputType.TEXT
                            placeholder = "Location"
                        }
                        input(className = "p-4 border-l focus:outline-none") {
                            type = InputType.DATE
                        }
                        button(className = "bg-indigo-600 text-white px-6 py-4", text = "Browse Properties")
                    }
                }
                +"""<!-- Hero Image -->"""
                div {
                    img(className = "rounded-lg shadow-lg", src = "https://via.placeholder.com/600x400")
                }
            }
        }
        section(className = "container mx-auto px-6 py-16 grid md:grid-cols-2 gap-12") {
            div(className = "max-w-md") {
                h2(className = "text-3xl font-bold mb-4") { +"""The new way to find your new home""" }
                p(className = "text-gray-600 mb-6") { +"""Find your dream place to live in with more than 10k+ properties listed.""" }
                a(
                    className = "inline-block bg-indigo-600 text-white px-6 py-3 rounded-lg hover:bg-indigo-500",
                    href = "/"
                ) {
                    +"""Browse Properties"""
                }
            }
            div(className = "grid grid-cols-1 sm:grid-cols-2 gap-8") {
                div(className = "flex space-x-4") {
                    div(className = "p-3 bg-indigo-100 rounded-full") {

                    }
                    div {
                        h3(className = "font-semibold") { +"""Property Insurance""" }
                        p(className = "text-gray-600 text-sm") { +"""We offer our customer property protection of liability coverage and insurance for their better life.""" }
                    }
                }
                div(className = "flex space-x-4") {
                    div(className = "p-3 bg-indigo-100 rounded-full") {

                    }
                    div {
                        h3(className = "font-semibold") { +"""Best Price""" }
                        p(className = "text-gray-600 text-sm") { +"""Not sure what you should be charging for your property? No need to worry, let us do the numbers for you.""" }
                    }
                }
                div(className = "flex space-x-4") {
                    div(className = "p-3 bg-indigo-100 rounded-full") {

                    }
                    div {
                        h3(className = "font-semibold") { +"""Lowest Commission""" }
                        p(className = "text-gray-600 text-sm") { +"""You no longer have to negotiate commissions and haggle with other agents it only cost 2%!""" }
                    }
                }
                div(className = "flex space-x-4") {
                    div(className = "p-3 bg-indigo-100 rounded-full") {

                    }
                    div {
                        h3(className = "font-semibold") { +"""Overall Control""" }
                        p(className = "text-gray-600 text-sm") { +"""Get a(className = "" )virtual tour, and schedule visits before you rent or buy any properties. You get overall control.""" }
                    }
                }
            }
        }
        section(className = "container mx-auto px-6 py-16") {
            h2(className = "text-2xl font-bold mb-6 text-center") { +"""Based on your location""" }
            div(className = "flex justify-center space-x-4 mb-6") {
                button(className = "px-4 py-2 bg-indigo-600 text-white rounded", text = "Rent") { +"""Rent""" }
                button(className = "px-4 py-2 text-gray-600 hover:text-indigo-600", text = "Buy") { +"""Buy""" }
                button(className = "px-4 py-2 text-gray-600 hover:text-indigo-600", text = "Sell") { +"""Sell""" }
                input(className = "ml-4 p-2 border rounded focus:outline-none w-48") {
                    type = InputType.TEXT
                    placeholder = "Search..."
                }
            }
            div(className = "grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8") {
                +"""<!-- Property Card -->"""
                div(className = "bg-white shadow rounded-lg overflow-hidden") {
                    div(className = "relative") {
                        img(className = "w-full h-48 object-cover", src = "https://via.placeholder.com/400x250") {
                            alt = "Property"
                        }
                        span(className = "absolute top-2 left-2 bg-indigo-600 text-white text-xs px-2 py-1 rounded") { +"""POPULAR""" }
                    }
                    div(className = "p-4") {
                        div(className = "flex items-baseline justify-between") {
                            span(className = "text-xl font-bold text-indigo-600") { +"""$2,095""" }
                            span(className = "text-gray-500 text-sm") { +"""/month""" }
                        }
                        h3(className = "mt-2 font-semibold") { +"""Palm Harbor""" }
                        p(className = "text-gray-500 text-sm") { +"""2699 Green Valley, Highland Lake, FL""" }
                        div(className = "mt-4 flex justify-between text-gray-600 text-sm") {
                            div(className = "flex items-center space-x-1") {
                                span { +"""3 Beds""" }
                            }
                            div(className = "flex items-center space-x-1") {
                                span { +"""2 Baths""" }
                            }
                            div(className = "flex items-center space-x-1") {

                                span { +"""5x7 m²""" }
                            }
                        }
                    }
                }
                +"""<!-- Repeat cards... -->"""
            }
            div(className = "text-center mt-8") {
                a(className = "px-6 py-3 bg-indigo-600 text-white rounded-lg") {

                    +"""Browse more properties"""
                }
            }
        }
        section(className = "bg-indigo-900 text-white py-16") {
            div(className = "container mx-auto px-6") {
                h2(className = "text-3xl font-bold mb-6") { +"""We make it easy for tenants and landlords.""" }
                div(className = "grid md:grid-cols-3 gap-6 mb-8") {
                    div(className = "bg-indigo-800 p-6 rounded-lg") {
                        h3(className = "font-semibold mb-2") { +"""Virtual home tour""" }
                        p(className = "text-sm") { +"""You can communicate directly with landlords and we provide you with virtual tour before you buy or rent the property.""" }
                    }
                    div(className = "bg-white text-gray-800 p-6 rounded-lg") {
                        h3(className = "font-semibold mb-2") { +"""Find the best deal""" }
                        p(className = "text-sm") { +"""Browse thousands of properties, save your favorites and set up search alerts so you don’t miss the best home deal!""" }
                    }
                    div(className = "bg-indigo-800 p-6 rounded-lg") {
                        h3(className = "font-semibold mb-2") { +"""Get financing""" }
                        p(className = "text-sm") { +"""We provide financing options to help you secure the property you want with the best rates.""" }
                    }
                }
                div(className = "flex justify-around text-center") {
                    div {
                        span(className = "text-3xl font-bold") { +"""7.4%""" }
                        p(className = "text-sm mt-1") { +"""Property Return Rate""" }
                    }
                    div {
                        span(className = "text-3xl font-bold") { +"""3,856""" }
                        p(className = "text-sm mt-1") { +"""Property in Sell & Rent""" }
                    }
                    div {
                        span(className = "text-3xl font-bold") { +"""2,540""" }
                        p(className = "text-sm mt-1") { +"""Daily Completed Transactions""" }
                    }
                }
            }
        }
        section(className = "container mx-auto px-6 py-16 text-center") {
            h2(className = "text-2xl font-bold mb-4") { +"""Are you a(className = "" )landlord?""" }
            p(className = "text-gray-600 mb-6") { +"""Discover ways to increase your home’s value and get listed. No Spam Promise.""" }
            form(className = "flex justify-center space-x-2") {
                input(className = "p-4 border rounded-l-lg focus:outline-none w-64") {
                    type = InputType.EMAIL
                    placeholder = "Enter your email address"
                }
                button(className = "bg-indigo-600 text-white px-6 rounded-r-lg", text = "Submit") { +"""Submit""" }
            }
            p(className = "text-gray-500 text-sm mt-4") { +"""Join 10,000+ other landlords in our estatery community.""" }
        }
        footer(className = "bg-white border-t py-10") {
            div(className = "container mx-auto px-6 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-5 gap-6") {
                div {
                    a(className = "text-2xl font-bold text-indigo-600", href = "/") {

                        +"""Estatery"""
                    }
                }
                div {
                    h3(className = "font-semibold mb-2") { +"""Sell a(className = "" )Home""" }
                    ul(className = "text-sm space-y-1 text-gray-600") {
                        li {
                            a(className = "") {

                                +"""Request an offer"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""Pricing"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""Reviews"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""Stories"""
                            }
                        }
                    }
                }
                div {
                    h3(className = "font-semibold mb-2") { +"""Buy, Rent and Sell""" }
                    ul(className = "text-sm space-y-1 text-gray-600") {
                        li {
                            a(className = "") {

                                +"""Buy and sell properties"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""Rent home"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""Builder trade-up"""
                            }
                        }
                    }
                }
                div {
                    h3(className = "font-semibold mb-2") { +"""About""" }
                    ul(className = "text-sm space-y-1 text-gray-600") {
                        li {
                            a(className = "") {

                                +"""Company"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""How it works"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""Contact"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""Investors"""
                            }
                        }
                    }
                }
                div {
                    h3(className = "font-semibold mb-2") { +"""Resources""" }
                    ul(className = "text-sm space-y-1 text-gray-600") {
                        li {
                            a(className = "") {

                                +"""Blog"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""Guides"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""FAQ"""
                            }
                        }
                        li {
                            a(className = "") {

                                +"""Help Center"""
                            }
                        }
                    }
                }
            }
            div(className = "text-center text-gray-500 text-sm mt-6") { +"""©2021 Estatery. All rights reserved.""" }
        }
    }
}
