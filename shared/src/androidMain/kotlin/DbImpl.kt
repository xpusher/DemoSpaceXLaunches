import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.project.AppDb

actual class DbImpl(private val context: Context): DbCommonImpl() {
    actual override suspend fun createDriver(): SqlDriver {
        val sqlDriver=AndroidSqliteDriver(
            schema = AppDb.Schema.synchronous(),
            context = context,
            callback = object :AndroidSqliteDriver.Callback(AppDb.Schema.synchronous()){},
            name = nameFileDb)
        AppDb.Schema.create(sqlDriver).await()
        return sqlDriver
    }

}