
import cleanArchitecturePlusSOLID.data.Db
import cleanArchitecturePlusSOLID.data.Network
import cleanArchitecturePlusSOLID.data.Repository


class RepositoryImpl : Repository {
    override val db: Db =DbImpl()
    override val network: Network=NetworkImpl()

}