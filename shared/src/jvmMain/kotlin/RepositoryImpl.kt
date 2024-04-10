
import cleanArchitecturePlusSOLID.data.Db
import cleanArchitecturePlusSOLID.data.Network


actual class RepositoryImpl : RepositoryCommonImpl() {
    override val db: Db =DbImpl()
    override val network: Network=NetworkImpl()
}