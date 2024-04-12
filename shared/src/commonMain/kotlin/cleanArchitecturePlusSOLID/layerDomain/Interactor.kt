package cleanArchitecturePlusSOLID.layerDomain

import cleanArchitecturePlusSOLID.layerData.Boundaries
import cleanArchitecturePlusSOLID.layerPresentation.Presentation
import cleanArchitecturePlusSOLID.layerDomain.usecase.UserActions
import cleanArchitecturePlusSOLID.layerPresentation.LaunchPresentation
import cleanArchitecturePlusSOLID.toLaunchPresentation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Interactor(
    private val presentation: Presentation,
    private val boundaries: Boundaries
) {
    val userActions = object :UserActions{

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