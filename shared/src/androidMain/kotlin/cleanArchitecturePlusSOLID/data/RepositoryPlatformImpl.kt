package cleanArchitecturePlusSOLID.data

import android.content.Context
import cleanArchitecturePlusSOLID.data.db.Db
import cleanArchitecturePlusSOLID.data.db.DbPlatformImpl
import cleanArchitecturePlusSOLID.data.network.NetworkPlatformImpl

actual class RepositoryPlatformImpl(context: Context) : RepositoryCommonImpl() {
    override val db: Db = DbPlatformImpl(context)
    override val network = NetworkPlatformImpl()
}