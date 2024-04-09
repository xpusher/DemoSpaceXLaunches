import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.usecase.UserActions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UserActionImpl(
    private val repository: Repository,
    private val presentation: Presentation):UserActions {

    override fun click() {

        CoroutineScope(Dispatchers.Unconfined + Job()).launch {
            presentation.mutableRocketLaunches.value=
                repository.network.testRequest()
        }

    }

}