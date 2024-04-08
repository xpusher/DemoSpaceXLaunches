import app.cash.sqldelight.Query
import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.domain.usecase.UserActions
import com.example.project.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserActionImpl(private val sqlDriver: SqlDriver?):UserActions {
    override var mutableTestString = MutableStateFlow<String>("00000000000")

    override fun testRequestKtor() {

        CoroutineScope(Dispatchers.Default).launch {
                sqlDriver?.let {
                    val player=Player(sqlDriver)
                    player.playerQueries.createTable()
                    player.playerQueries.createIndex()
                    player.playerQueries.insertTest()
                    mutableTestString.value=player.playerQueries.selectAll().awaitAsList().toString()
                }

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