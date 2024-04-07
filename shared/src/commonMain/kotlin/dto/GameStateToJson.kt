package dto

import cleanArchitecturePlusSOLID.domain.entity.GameState

interface GameStateToJson {
    fun toString(gameState:GameState):String?
}