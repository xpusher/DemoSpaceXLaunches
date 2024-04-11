package cleanArchitecturePlusSOLID.layerData.Repository

import cleanArchitecturePlusSOLID.layerData.Repository.db.Db
import cleanArchitecturePlusSOLID.layerData.Repository.db.DbPlatformImpl
import cleanArchitecturePlusSOLID.layerData.Repository.network.NetworkPlatformImpl

actual class RepositoryPlatformImpl : Repository {
    override val db: Db = DbPlatformImpl()
    override val network= NetworkPlatformImpl()
}