
import cleanArchitecturePlusSOLID.data.Db
import cleanArchitecturePlusSOLID.data.Repository


class RepositoryImpl : Repository {
    override val db: Db =DbImpl()
}