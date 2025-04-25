package com.example.full_stack_ktor.ui.cms.pages.view_model

import com.copperleaf.ballast.EventHandler
import com.copperleaf.ballast.EventHandlerScope

class PagesEventHandler : EventHandler<
        PagesContract.Inputs,
        PagesContract.Events,
        PagesContract.State> {
    override suspend fun EventHandlerScope<
            PagesContract.Inputs,
            PagesContract.Events,
            PagesContract.State>.handleEvent(
        event: PagesContract.Events
    ): Unit = when (event) {
        is PagesContract.Events.NavigateUp -> {

        }
    }
}
