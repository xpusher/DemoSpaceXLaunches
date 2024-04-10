
import cleanArchitecturePlusSOLID.data.RepositoryCommonImpl
import cleanArchitecturePlusSOLID.data.db.Db


actual class RepositoryImpl : RepositoryCommonImpl() {
    override val db: Db =DbImpl()
    override val network= NetworkImpl()
}