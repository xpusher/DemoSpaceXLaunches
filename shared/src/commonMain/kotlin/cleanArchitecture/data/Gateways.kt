package cleanArchitecture.data

import cleanArchitecture.domain.entity.GameState
import kotlinx.coroutines.flow.MutableStateFlow

abstract class Gateways {

    lateinit var  mutableGameState:MutableStateFlow<GameState>
    abstract fun readGameState()
    abstract fun storeGameState(gameState: GameState)

    abstract fun testRequestKtor()
}