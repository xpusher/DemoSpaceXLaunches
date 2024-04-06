package cleanArchitecture.domain.entity

import dto.GameStateFromJson
import dto.GameStateToJson

class GameState private constructor(
    val edgeSize:Int,
    var string: String?=null
) {
    constructor():this(edgeSize=DEFAULT_EDGE_SIZE)
    companion object{

        const val DEFAULT_EDGE_SIZE=2
        fun create():GameState{
            return GameState()
        }
        fun create4():GameState{
            return GameState(edgeSize = 4)
        }
        fun create(fromJson: GameStateFromJson):GameState{
            return GameState(edgeSize = fromJson.edgeSize)
        }

        fun toJson(toJson: GameStateToJson):String{
            return toJson.toString()
        }

    }

}