package cleanArchitecture.layerData.Repository.network

import cleanArchitecture.layerDomain.entity.LaunchNetwork
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

abstract class NetworkCommonImpl: Network {

    override val url="https://api.spacexdata.com/v5/launches"
    override suspend fun requestLaunches(): List<LaunchNetwork> {
        Json.Default.encodeToJsonElement(listOf<Long>())
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