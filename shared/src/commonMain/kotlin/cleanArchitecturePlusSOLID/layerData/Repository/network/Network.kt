package cleanArchitecturePlusSOLID.layerData.Repository.network

import cleanArchitecturePlusSOLID.layerDomain.entity.RocketLaunch

interface Network {
    val url:String
    suspend fun testRequest():List<RocketLaunch>

}