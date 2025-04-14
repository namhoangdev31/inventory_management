package com.example.full_stack_ktor.app.landing.pages.landingPage

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope
import com.copperleaf.ballast.navigation.routing.RouterContract
import com.copperleaf.ballast.navigation.routing.build
import com.copperleaf.ballast.navigation.routing.directions
import com.example.full_stack_ktor.app.AppRouter
import com.example.full_stack_ktor.app.AppRouterViewModel

class LandingPageEventHandler(
    private val routerViewModel: AppRouterViewModel
) : EventHandler<
        LandingPageContract.Inputs,
        LandingPageContract.Events,
        LandingPageContract.State> {
    override suspend fun EventHandlerScope<
            LandingPageContract.Inputs,
            LandingPageContract.Events,
            LandingPageContract.State>.handleEvent(
        event: LandingPageContract.Events
    ) = when (event) {
        is LandingPageContract.Events.NavigateToContactListPage -> {
            routerViewModel.trySend(
                RouterContract.Inputs.GoToDestination(
                    AppRouter.ContactList.directions().build()
                )
            )
            Unit
        }
    }
}
