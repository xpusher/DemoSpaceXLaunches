
import android.content.Context
import android.content.Context.MODE_PRIVATE
import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.entity.GameState
import dto.GameStateFromJson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class RepositoryImpl(context: Context) : Repository {

    private val sharedPreferences=
        context.getSharedPreferences(
            "AndroidPref",
            MODE_PRIVATE)

    sealed class KeysPref{
        data object KeysPrefGameState : KeysPref()
    }

    override fun readGameState():GameState {
        return GameState.create(object :GameStateFromJson{
            override val edgeSize: Int
                get() = sharedPreferences.getString(
                    KeysPref.KeysPrefGameState::class.simpleName,
                    null)?.toInt()?:GameState.DEFAULT_EDGE_SIZE

        })
    }

    override fun storeGameState(gameState: GameState) {

    }

    override val mutableGameState =
        MutableStateFlow(this.readGameState())

    override val mutableSqlDriver = MutableStateFlow<SqlDriver?>(null)

    init {
        CoroutineScope(Dispatchers.Default).launch {
            mutableSqlDriver.value = DriverFactory(context).createDriver()
        }
    }

}