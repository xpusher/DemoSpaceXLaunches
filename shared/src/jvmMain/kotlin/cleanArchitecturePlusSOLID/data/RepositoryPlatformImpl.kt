package cleanArchitecturePlusSOLID.data

import cleanArchitecturePlusSOLID.data.db.Db
import cleanArchitecturePlusSOLID.data.db.DbPlatformImpl
import cleanArchitecturePlusSOLID.data.network.Network
import cleanArchitecturePlusSOLID.data.network.NetworkPlatformImpl

actual class RepositoryPlatformImpl : Repository {
    override val db: Db = DbPlatformImpl()
    override val network: Network = NetworkPlatformImpl()
}