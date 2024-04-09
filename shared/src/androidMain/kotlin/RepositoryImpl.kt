
import android.content.Context
import cleanArchitecturePlusSOLID.data.Db
import cleanArchitecturePlusSOLID.data.Repository


actual class RepositoryImpl(context: Context) : Repository {
    override val db: Db =DbImpl(context)
    override val network = NetworkImpl()
}