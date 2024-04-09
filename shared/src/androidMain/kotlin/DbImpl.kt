import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import cleanArchitecturePlusSOLID.data.Db
import com.example.project.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

actual class DbImpl(private val context: Context): DbBaseImpl() {
    actual override suspend fun createDriver(): SqlDriver {
        val sqlDriver=AndroidSqliteDriver(
            schema = Player.Schema.synchronous(),
            context = context,
            callback = object :AndroidSqliteDriver.Callback(Player.Schema.synchronous()){},
            name = nameFileDb)
        Player.Schema.create(sqlDriver).await()
        return sqlDriver
    }

}