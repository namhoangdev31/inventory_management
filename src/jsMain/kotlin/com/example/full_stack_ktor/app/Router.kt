package com.example.full_stack_ktor.app

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.ExperimentalBallastApi
import com.copperleaf.ballast.build
import com.copperleaf.ballast.eventHandler
import com.copperleaf.ballast.navigation.browser.withBrowserHistoryRouter
import com.copperleaf.ballast.navigation.routing.*
import com.copperleaf.ballast.navigation.vm.BasicRouter
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.Serializable
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

@Serializable
enum class AppRouter(
    routeFormat: String,
    override val annotations: Set<RouteAnnotation> = emptySet()
) : Route {
    Root("/"),
    Home("/home"),
    Login("/login"),
    Signup("/signup"),
    About("/about"),
    SuperAdmin("/super-admin"),
    CMSAdmin("/cms-admin"),
    CMSLogin("/cms-login"),
    CMSHeader("/cms-admin/header"),
    CMSPage("/cms-admin/page"),
    CMSFooter("/cms-admin/footer"),
    CMSSiderBar("/cms-admin/sidebar"),
    CMSContent("/cms-admin/content"),
    CMSMedia("/cms-admin/media"),
    CMSCategories("/cms-admin/categories"),
    CMSPost("/cms-admin/post"),
    CMSBlog("/cms-admin/blog");

    override val matcher: RouteMatcher = RouteMatcher.create(routeFormat)
}

@OptIn(ExperimentalBallastApi::class)
class AppRouterViewModel(
    coroutineScope: CoroutineScope,
    config: BallastViewModelConfiguration.Builder
) : BasicRouter<AppRouter>(
    config = config
        .withBrowserHistoryRouter(
            RoutingTable.fromEnum(AppRouter.entries.toTypedArray()),
            initialRoute = AppRouter.Root
        )
        .build(),
    eventHandler = eventHandler { },
    coroutineScope = coroutineScope
)

val routerModule = module {
    singleOf(::AppRouterViewModel)
}