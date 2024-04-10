
import cleanArchitecturePlusSOLID.data.RepositoryCommonImpl
import cleanArchitecturePlusSOLID.data.db.Db
import cleanArchitecturePlusSOLID.data.network.Network


actual class RepositoryImpl : RepositoryCommonImpl() {
    override val db: Db =DbImpl()
    override val network: Network =NetworkImpl()
}