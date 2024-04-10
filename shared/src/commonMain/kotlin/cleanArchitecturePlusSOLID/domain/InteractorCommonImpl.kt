package cleanArchitecturePlusSOLID.domain

import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.usecase.UserActions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class InteractorCommonImpl(
    override val presentation: Presentation,
    override val repository: Repository) : Interactor(){

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