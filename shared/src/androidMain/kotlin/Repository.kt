
import android.content.Context
import android.content.Context.MODE_PRIVATE
import cleanArchitecture.data.Gateways
import cleanArchitecture.domain.entity.GameState
import com.example.project.Player
import dto.GameStateFromJson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class Repository(private val context: Context) : Gateways() {
    init {
        mutableGameState= MutableStateFlow(GameState.create())

    }

    private val sharedPreferences=
        context.getSharedPreferences(
            "AndroidPref",
            MODE_PRIVATE)

    sealed class KeysPref{
        data object KeysPrefGameState : KeysPref()
    }

    override fun readGameState() {
        mutableGameState.value=GameState.create(object :GameStateFromJson{
            override val edgeSize: Int
                get() = sharedPreferences.getString(
                    KeysPref.KeysPrefGameState::class.simpleName,
                    null)?.toInt()?:GameState.DEFAULT_EDGE_SIZE

        })
    }

    override fun storeGameState(gameState: GameState) {

    }

    override fun testRequestKtor() {

        val q= Player(DriverFactory(context = context).createDriver())
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