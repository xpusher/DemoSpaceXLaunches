package cleanArchitecturePlusSOLID.layerDomain

import cleanArchitecturePlusSOLID.layerPresentation.Presentation
import cleanArchitecturePlusSOLID.layerData.Repository.Repository
import cleanArchitecturePlusSOLID.layerDomain.usecase.UserActions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class InteractorImpl(
    override val presentation: Presentation,
    override val repository: Repository
) : Interactor(){
    override val userActions = object :UserActions{

        override fun click() {

            CoroutineScope(Dispatchers.Unconfined + Job())
                .launch {

                    presentation.mutableRocketLaunches.value=
                        repository.network.testRequest()

                }

        }
    }
}