package cleanArchitecture.layerData.Repository.network

import cleanArchitecture.layerDomain.entity.LaunchNetwork
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

abstract class NetworkCommonImpl: Network {

    override val url="https://api.spacexdata.com/v5/launches"
    override suspend fun requestLaunches(): List<LaunchNetwork> {
        val client = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }
        }
        return client.get(url).body()
    }

}