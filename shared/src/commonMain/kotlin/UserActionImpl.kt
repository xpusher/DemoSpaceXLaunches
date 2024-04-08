import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOne
import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.usecase.UserActions
import com.example.project.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserActionImpl(
    private val repository: Repository,
    private val presentation: Presentation):UserActions {

    override fun click() {

        CoroutineScope(Dispatchers.Default).launch {
            repository.db.addTestRecord()
            presentation.mutableTestString.value=
                repository.db.readAllRecords().toString()
        }

//
////            val client = HttpClient(CIO) {}
////
////            val response: HttpResponse = client.get("https://httpbin.org/get")
////
////            mutableGameState.value = GameState.create4().apply {
////                string = String(response.readBytes())
////            }
//        }

    }

}