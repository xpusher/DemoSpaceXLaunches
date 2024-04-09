import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import cleanArchitecturePlusSOLID.data.Db
import com.example.project.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

actual class DbImpl: DbBaseImpl() {

    actual override suspend fun createDriver(): SqlDriver {
        val sqlDriver=
            NativeSqliteDriver(
                Player.Schema.synchronous(), nameFileDb)

        //Player.Schema.create(sqlDriver).await()

        return sqlDriver
    }

}