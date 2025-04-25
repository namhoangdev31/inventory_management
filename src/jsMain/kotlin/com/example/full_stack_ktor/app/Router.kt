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
    Admin("/admin"),
    Login("/login"),
    Signup("/signup"),
    About("/about"),
    CMSAdmin("/cms-admin"),
    CMSLogin("/cms-login"),
    CMSHeader("/cms-header"),
    CMSPage("/cms-pages"),
    CMSFooter("/cms-footer"),
    CMSSiderBar("/cms-sidebar"),
    CMSContent("/cms-content"),
    CMSMedia("/cms-media"),
    CMSCategories("/cms-categories"),
    CMSPost("/cms-posts"),
    CMSPostDetail("/cms-posts/:postId"),
    CMSBlog("/cms-blogs");

    override val matcher: RouteMatcher = RouteMatcher.create(routeFormat)
}

@OptIn(ExperimentalBallastApi::class)
class AppRouterViewModel(
    viewModelCoroutineScope: CoroutineScope,
    config: BallastViewModelConfiguration.Builder
) : BasicRouter<AppRouter>(
    config = config
        .withBrowserHistoryRouter(
            RoutingTable.fromEnum(AppRouter.entries.toTypedArray()),
            initialRoute = AppRouter.Root,
            basePath = "/"
        )
        .build(),
    eventHandler = eventHandler { event ->
        when (event) {
            is RouterContract.Events.BackstackChanged -> {
                console.log(event.backstack.currentDestinationOrNull , "Backstack changed")
            }
            else -> error("Unexpected event: $event")
        }
    },
    coroutineScope = viewModelCoroutineScope
)

val routerModule = module {
    singleOf(::AppRouterViewModel)
}