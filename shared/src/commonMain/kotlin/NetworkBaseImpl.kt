import cleanArchitecturePlusSOLID.data.Network
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

abstract class NetworkBaseImpl:Network {
    override val url="https://httpbin.org/get"
    override suspend fun testRequest(): String? {
        val client = HttpClient{
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }
        }
        val response: HttpResponse = client.get(url)
        return response.body()

    }

}