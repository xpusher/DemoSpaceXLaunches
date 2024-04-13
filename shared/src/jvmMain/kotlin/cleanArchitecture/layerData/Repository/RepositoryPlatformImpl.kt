package cleanArchitecture.layerData.Repository

import cleanArchitecture.layerData.Repository.Repository
import cleanArchitecture.layerData.Repository.db.Db
import cleanArchitecture.layerData.Repository.db.DbPlatformImpl
import cleanArchitecture.layerData.Repository.network.Network
import cleanArchitecture.layerData.Repository.network.NetworkPlatformImpl
import kotlinx.coroutines.runBlocking

actual class RepositoryPlatformImpl : Repository {
    override val db: Db = DbPlatformImpl()
    override val network: Network = NetworkPlatformImpl()
}