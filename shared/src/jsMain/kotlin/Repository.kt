
import cleanArchitecture.data.Gateways
import cleanArchitecture.domain.entity.GameState
import com.example.project.Player
import kotlinx.coroutines.flow.MutableStateFlow


class Repository() : Gateways() {
    init {
        mutableGameState= MutableStateFlow(GameState.create())

    }


    override fun readGameState() {
    }

    override fun storeGameState(gameState: GameState) {

    }

    override fun testRequestKtor() {

//        val q= Player(DriverFactory().createDriver())
//        q.playerQueries.selectAll()

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