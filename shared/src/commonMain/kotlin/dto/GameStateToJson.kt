package dto

import cleanArchitecture.domain.entity.GameState

interface GameStateToJson {
    fun toString(gameState:GameState):String?
}