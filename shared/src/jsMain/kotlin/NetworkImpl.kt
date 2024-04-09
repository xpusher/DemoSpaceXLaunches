import cleanArchitecturePlusSOLID.data.Network
import org.w3c.xhr.XMLHttpRequest

actual class NetworkImpl: Network {
    override suspend fun testRequest():String? {

        XMLHttpRequest().apply {
            open("GET","https://httpbin.org/get",async = false)
            send()
            return responseText
        }

    }
}