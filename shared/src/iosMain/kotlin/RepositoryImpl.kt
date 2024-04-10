
import cleanArchitecturePlusSOLID.data.Db
import cleanArchitecturePlusSOLID.data.Repository


actual class RepositoryImpl : RepositoryCommonImpl() {
    override val db: Db =DbImpl()
    override val network= NetworkImpl()
}