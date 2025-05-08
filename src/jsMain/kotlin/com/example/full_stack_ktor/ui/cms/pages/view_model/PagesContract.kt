package com.example.full_stack_ktor.ui.cms.pages.view_model

import com.example.full_stack_ktor.model.PagesModel

object PagesContract {
    data class State(
        val loading: Boolean = false,
        val listSelect : List<PagesModel> = emptyList<PagesModel>()
    )

    sealed interface Inputs {
        object Initialize : Inputs
        object GoBack : Inputs
    }

    sealed interface Events {
        object NavigateUp : Events
    }
}
