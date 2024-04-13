package cleanArchitecture.layerDomain

import cleanArchitecture.layerData.Boundaries
import cleanArchitecture.layerDomain.entity.LaunchPresentation
import cleanArchitecture.layerPresentation.Presentation
import cleanArchitecture.layerDomain.usecase.UserActions
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

        override fun updateLaunches() {

            CoroutineScope(Dispatchers.Unconfined + Job())
                .launch {

                    presentation.mutableLaunchesPresentation.value=null

                    boundaries.clearDb()

                    loadLaunches()

                }

        }

        override fun loadLaunches() {
            CoroutineScope(Dispatchers.Unconfined + Job())
                .launch {

                    presentation.mutableLaunchesPresentation.value =
                        ArrayList<LaunchPresentation>()
                            .apply {
                                boundaries.requestLaunches().forEach {
                                    add(it.toLaunchPresentation())
                                }
                            }
                }
        }
    }
}