package cleanArchitecturePlusSOLID.data.network

import cleanArchitecturePlusSOLID.domain.entity.RocketLaunch

interface Network {
    val url:String
    suspend fun testRequest():List<RocketLaunch>

}