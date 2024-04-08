import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.project.Player

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        //return  JdbcSqliteDriver("jdbc:sqlite:file:memdb1?cache=shared")
        return NativeSqliteDriver(Player.Schema.synchronous(), "test.db")
    }
}