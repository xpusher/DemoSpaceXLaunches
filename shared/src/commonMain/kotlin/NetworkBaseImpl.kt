import cleanArchitecturePlusSOLID.data.Network
import cleanArchitecturePlusSOLID.domain.entity.RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

abstract class NetworkBaseImpl:Network {
    //override val url="https://httpbin.org/get"
    override val url="https://api.spacexdata.com/v5/launches"
    override suspend fun testRequest(): List<RocketLaunch> {
        val client = HttpClient{
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }
        }
        val q:List<RocketLaunch> = client.get(url).body()
        return q

    }

}