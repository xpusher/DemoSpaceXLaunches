
import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.entity.GameState
import kotlinx.coroutines.flow.MutableStateFlow


class RepositoryImpl : Repository {

    override val mutableGameState =
        MutableStateFlow(GameState.create())


    override fun readGameState():GameState {
        return GameState.create()
    }

    override fun storeGameState(gameState: GameState) {
    }

    override val sqlDriver: SqlDriver =
        DriverFactory().createDriver()

}