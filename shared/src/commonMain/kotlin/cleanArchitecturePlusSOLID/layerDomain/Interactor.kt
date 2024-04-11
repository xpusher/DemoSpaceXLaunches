package cleanArchitecturePlusSOLID.layerDomain

import cleanArchitecturePlusSOLID.layerData.Boundaries
import cleanArchitecturePlusSOLID.layerPresentation.Presentation
import cleanArchitecturePlusSOLID.layerDomain.usecase.UserActions
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

                    presentation.mutableRocketLaunches.value=
                        boundaries.testRequest()

                }

        }
    }
}