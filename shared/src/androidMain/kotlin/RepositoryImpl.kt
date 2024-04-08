
import android.content.Context
import android.content.Context.MODE_PRIVATE
import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.Db
import cleanArchitecturePlusSOLID.data.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class RepositoryImpl(context: Context) : Repository {
    override val db: Db =DbImpl(context)
}