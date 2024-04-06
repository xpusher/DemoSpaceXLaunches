import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.example.project.Player

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return  JdbcSqliteDriver("jdbc:sqlite:file:memdb1?cache=shared")
        //return NativeSqliteDriver(Player.Schema, "test.db")
    }
}