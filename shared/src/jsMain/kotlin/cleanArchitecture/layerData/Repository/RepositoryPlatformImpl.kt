package cleanArchitecture.layerData.Repository

import cleanArchitecture.layerData.Repository.db.Db
import cleanArchitecture.layerData.Repository.db.DbPlatformImpl
import cleanArchitecture.layerData.Repository.network.NetworkPlatformImpl
import kotlinx.browser.localStorage
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.w3c.dom.events.Event
import org.w3c.dom.events.EventListener
import org.w3c.dom.set

actual class RepositoryPlatformImpl : Repository {
    override val db: Db = DbPlatformImpl()
    override val network= NetworkPlatformImpl()
    init {
        window.addEventListener(
            type = "beforeunload",
            callback = {event: Event-> })
    }
}