package com.example.full_stack_ktor.ui.cms.admin

import com.example.full_stack_ktor.app.AppRouterViewModel
import com.example.full_stack_ktor.ui.cms.components.DashBoardComponentProps
import com.example.full_stack_ktor.ui.cms.components.dashBoardComponent
import com.example.full_stack_ktor.util.CookieFacade
import com.example.full_stack_ktor.util.LocalStorageFacade
import io.kvision.core.Container
import io.kvision.html.*
import io.kvision.state.bind
import io.kvision.utils.px
import io.kvision.utils.vh
import io.kvision.utils.vw
import io.kvision.utils.set
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

fun Container.adminCmsPage(): KoinComponent = object : KoinComponent {
	val router by inject<AppRouterViewModel>()
	val userToken = CookieFacade.getCookie(LocalStorageFacade.KEY_CMS_ACCESS_TOKEN)
	
	init {
//            if (userToken == null) {
//                router.trySend(
//                    RouterContract.Inputs.GoToDestination(
//                        AppRouter.CMSLogin.directions().build()
//                    )
//                )
//            }
		div(className = "relative flex flex-col gap-6 min-h-screen").bind(router) { appRouterState ->
			p(className = "text-center text-lg font-bold text-gray-800") {
				+"CMS Admin"
			}
			div(className = "grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 xl:grid-cols-5 gap-4") {
				// Add your dashboard components here
				dashBoardComponent(
					DashBoardComponentProps(
						title = "Pages",
						onClick = {
						
						}
					)
				)
				dashBoardComponent(
					DashBoardComponentProps(
						title = "Products",
						onClick = {
						
						}
					)
				)
				dashBoardComponent(
					DashBoardComponentProps(
						title = "Orders",
						onClick = {
						
						}
					)
				)
			}
		}
	}
}

//val inputArea = TextArea{
//    rows = 40
//    cols = 100
//    width = 50.vw
//    height = 100.vh
//    placeholder = "Enter some text"
//    autofocus = true
//    wrapHard = true
//    padding = 10.px
//}
//val previewArea = Div(
//    className = "w-full h-full border p-4 bg-gray-50 overflow-auto"
//)
//
//div(className = "flex h-screen p-4") {
//    div(className = "w-1/2 h-full") {
//        add(inputArea)
//    }
//    div(className = "w-1/2 h-full") {
//        add(previewArea)
//    }
//}
//
//inputArea.onInput {
//    previewArea.getElement()?.innerHTML = inputArea.value ?: ""
//}
//
//val defaultHtml = """
//        <div class="p-6 bg-white rounded-lg shadow-md rounder-lg">
//            <h1 class="text-2xl font-bold text-indigo-600">Hello Tailwind!</h1>
//            <p class="text-gray-600 mt-2">This is a preview box styled with Tailwind classes.</p>
//            <button class="mt-4 px-4 py-2 bg-indigo-600 text-white rounded hover:bg-indigo-500">Click Me</button>
//        </div>
//    """.trimIndent()
//
//inputArea.value = defaultHtml
//previewArea.getElement()?.innerHTML = defaultHtml