package com.example.full_stack_ktor

import io.kvision.navigo.Navigo
import kotlin.js.RegExp

enum class View(val url: String) {
    HOME("/"),
    ARTICLE("/article"),
    PROFILE("/@"),
    LOGIN("/login"),
    REGISTER("/register"),
    EDITOR("/editor"),
    SETTINGS("/settings"),
}

fun Navigo.initialize(): Navigo {
    return on(View.HOME.url, { _ ->
        ConduitManager.homePage()
    }).on("${View.ARTICLE.url}/:slug", { params ->
        ConduitManager.showArticle(stringParameter(params, "slug"))
    }).on(RegExp("^${View.PROFILE.url}([^/]+)$"), { username ->
        ConduitManager.showProfile(username.toString(), false)
    }).on(RegExp("^${View.PROFILE.url}([^/]+)/favorites$"), { username ->
        ConduitManager.showProfile(username.toString(), true)
    }).on(View.LOGIN.url, { _ ->
        ConduitManager.loginPage()
    }).on(View.REGISTER.url, { _ ->
        ConduitManager.registerPage()
    }).on(View.SETTINGS.url, { _ ->
        ConduitManager.settingsPage()
    }).on(View.EDITOR.url, { _ ->
        ConduitManager.editorPage()
    }).on("${View.EDITOR.url}/:slug", { params ->
        ConduitManager.editorPage(stringParameter(params, "slug"))
    })
}

fun stringParameter(params: dynamic, parameterName: String): String {
    return (params[parameterName]).toString()
}
