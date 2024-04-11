package cleanArchitecturePlusSOLID.layerData.Repository

import android.content.Context
import cleanArchitecturePlusSOLID.layerData.Repository.db.Db
import cleanArchitecturePlusSOLID.layerData.Repository.db.DbPlatformImpl
import cleanArchitecturePlusSOLID.layerData.Repository.network.NetworkPlatformImpl

actual class RepositoryPlatformImpl(context: Context) : Repository {
    override val db: Db = DbPlatformImpl(context)
    override val network = NetworkPlatformImpl()
}