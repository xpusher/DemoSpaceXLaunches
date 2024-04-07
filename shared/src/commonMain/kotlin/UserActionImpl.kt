import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.domain.usecase.UserActions
import com.example.project.Player

class UserActionImpl(private val sqlDriver: SqlDriver?):UserActions {
    override fun testRequestKtor() {

        sqlDriver?.let {
            val q= Player(sqlDriver)
            //q.playerQueries.selectAll()

        }

//        CoroutineScope(Dispatchers.Default + Job()).launch {
//            val client = HttpClient(CIO) {}
//
//            val response: HttpResponse = client.get("https://httpbin.org/get")
//
//            mutableGameState.value = GameState.create4().apply {
//                string = String(response.readBytes())
//            }
//        }
    }

}