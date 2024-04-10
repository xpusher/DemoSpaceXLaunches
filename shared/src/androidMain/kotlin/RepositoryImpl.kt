
import android.content.Context
import cleanArchitecturePlusSOLID.data.RepositoryCommonImpl
import cleanArchitecturePlusSOLID.data.db.Db


actual class RepositoryImpl(context: Context) : RepositoryCommonImpl() {
    override val db: Db =DbImpl(context)
    override val network = NetworkImpl()
}