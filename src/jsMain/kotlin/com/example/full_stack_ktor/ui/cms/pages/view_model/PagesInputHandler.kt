package com.example.full_stack_ktor.ui.cms.pages.view_model

import com.copperleaf.ballast.InputHandler
import com.copperleaf.ballast.InputHandlerScope
import com.example.full_stack_ktor.model.PagesModel
import io.kvision.types.LocalDateTime
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
            console.log("PagesInputHandler: Initialize")
            updateState { it.copy(loading = true) }
            updateState { it.copy(listSelect = emptyList()) }
            val pages = listOf(
                PagesModel(
                    id = "1",
                    pageName = "Card",
                    pageSlug = "card",
                    updateAt = LocalDateTime.now(),
                ),
                PagesModel(
                    id = "2",
                    pageName = "Card 1",
                    pageSlug = "card_1",
                    updateAt = LocalDateTime.now(),
                ),
            )
            updateState { it.copy(listSelect = pages, loading = false) }
        }

        is PagesContract.Inputs.GoBack -> {
            postEvent(PagesContract.Events.NavigateUp)
        }
    }
}
