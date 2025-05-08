package com.example.full_stack_ktor.ui.cms.pages.view_model

import com.copperleaf.ballast.BallastViewModelConfiguration
import com.copperleaf.ballast.build
import com.copperleaf.ballast.core.BasicViewModel
import com.copperleaf.ballast.withViewModel
import kotlinx.coroutines.CoroutineScope

class PagesViewModel(
    coroutineScope: CoroutineScope,
    configBuilder: BallastViewModelConfiguration.Builder,
) : BasicViewModel<
        PagesContract.Inputs,
        PagesContract.Events,
        PagesContract.State>(
    coroutineScope = coroutineScope,
    config = configBuilder
        .withViewModel(
            inputHandler = PagesInputHandler(),
            initialState = PagesContract.State(),
            name = "Pages",
        )
        .build(),
    eventHandler = PagesEventHandler(),
) {
    init {
        trySend(PagesContract.Inputs.Initialize)
    }
}
