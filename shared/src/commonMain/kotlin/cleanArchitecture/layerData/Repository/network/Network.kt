package cleanArchitecture.layerData.Repository.network

import cleanArchitecture.layerDomain.entity.LaunchNetwork

interface Network {
    val url:String
    suspend fun requestLaunches():List<LaunchNetwork>

}