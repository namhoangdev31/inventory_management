package com.example.full_stack_ktor.ui.cms.pages.view_model

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import kotlinx.coroutines.delay

class PagesInputHandler : InputHandler<
        PagesContract.Inputs,
        PagesContract.Events,
        PagesContract.State> {
    override suspend fun InputHandlerScope<
            PagesContract.Inputs,
            PagesContract.Events,
            PagesContract.State>.handleInput(
        input: PagesContract.Inputs
    ): Unit = when (input) {
        is PagesContract.Inputs.Initialize -> {
            updateState { it.copy(loading = true) }
            delay(1000)
            updateState { it.copy(loading = false) }
        }

        is PagesContract.Inputs.GoBack -> {
            postEvent(PagesContract.Events.NavigateUp)
        }
    }
}
