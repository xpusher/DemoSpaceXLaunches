
import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.entity.GameState
import com.example.project.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class RepositoryImpl : Repository {

    override fun readGameState():GameState {
        return GameState.create()
    }

    override fun storeGameState(gameState: GameState) {

    }

    override val mutableGameState =
        MutableStateFlow(GameState.create())

    override val mutableSqlDriver = MutableStateFlow<SqlDriver?>(null)

    init {
        CoroutineScope(Dispatchers.Default).launch {
            mutableSqlDriver.value = DriverFactory().createDriver()
        }
    }
}