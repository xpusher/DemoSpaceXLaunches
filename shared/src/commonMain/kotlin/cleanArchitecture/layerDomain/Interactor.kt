package cleanArchitecture.layerDomain

import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerPresentation.Presentation
import cleanArchitecture.layerDomain.usecase.UserActions
import cleanArchitecture.layerPresentation.LaunchPresentation
import cleanArchitecture.toLaunchPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Interactor(
    private val presentation: Presentation,
    private val boundaries: Boundaries
) {
    val userActions = object : UserActions {

        override fun click() {

            CoroutineScope(Dispatchers.Unconfined + Job())
                .launch {

                    presentation.mutableLaunchesPresentation.value=
                        ArrayList<LaunchPresentation>()
                            .apply {
                                boundaries.testRequest().forEach { add(it.toLaunchPresentation()) }
                            }
                }

        }
    }
}