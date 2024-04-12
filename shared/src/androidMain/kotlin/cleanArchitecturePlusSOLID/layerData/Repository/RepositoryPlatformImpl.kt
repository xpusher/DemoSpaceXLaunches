package cleanArchitecturePlusSOLID.layerData.Repository

import android.content.Context
import cleanArchitecture.layerData.Repository.Repository
import cleanArchitecture.layerData.Repository.db.Db
import cleanArchitecture.layerData.Repository.db.DbPlatformImpl
import cleanArchitecture.layerData.Repository.network.NetworkPlatformImpl

actual class RepositoryPlatformImpl(context: Context) : Repository {
    override val db: Db = DbPlatformImpl(context)
    override val network = NetworkPlatformImpl()
}