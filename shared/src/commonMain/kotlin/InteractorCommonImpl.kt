import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.Interactor
import cleanArchitecturePlusSOLID.domain.usecase.UserActions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class InteractorCommonImpl: Interactor{

    override val presentation= PresentationImpl()

    override val userActions = object :UserActions{

        override fun click() {

            CoroutineScope(Dispatchers.Unconfined + Job()).launch {
                presentation.mutableRocketLaunches.value=
                    repository.network.testRequest()

                repository.db.addTestRecord()
            }

        }
    }
}