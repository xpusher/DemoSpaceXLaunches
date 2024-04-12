package cleanArchitecture.layerData.Repository.network

import cleanArchitecture.layerDomain.entity.RocketLaunch

interface Network {
    val url:String
    suspend fun testRequest():List<RocketLaunch>

}