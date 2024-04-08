package cleanArchitecturePlusSOLID.data

import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.domain.entity.GameState
import cleanArchitecturePlusSOLID.domain.usecase.UserActions
import kotlinx.coroutines.flow.MutableStateFlow

//region SOLID -  OCP, LSP, ISP, DIP
interface Repository:ReadGameState,StoreGameState {
    val  mutableGameState:MutableStateFlow<GameState>
    val mutableSqlDriver:MutableStateFlow<SqlDriver?>
}
//endregion

//region SOLID - SRP
interface ReadGameState{
    fun readGameState(): GameState

}
interface StoreGameState{
    fun storeGameState(gameState: GameState)
}

//endregion