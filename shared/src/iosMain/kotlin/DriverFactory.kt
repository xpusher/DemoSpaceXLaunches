import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.project.Player

actual class DriverFactory {
    private val nameFileDb="test.db"
    actual suspend fun createDriver(): SqlDriver {
        val sqlDriver=
            NativeSqliteDriver(
                Player.Schema.synchronous(), nameFileDb)

        Player.Schema.create(sqlDriver).await()

        return sqlDriver
    }
}