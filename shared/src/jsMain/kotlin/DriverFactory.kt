
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import com.example.project.Player
import org.w3c.dom.Worker

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        //return JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        //JdbcSqliteDriver("jdbc:sqlite:file:memdb1?cache=shared")
        //return NativeSqliteDriver(Player.Schema, "test.db")
        return WebWorkerDriver(
            Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            )
        )
    }
}