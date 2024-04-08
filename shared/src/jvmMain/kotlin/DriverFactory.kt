import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.example.project.Player
import kotlinx.coroutines.runBlocking
import java.io.File

actual class DriverFactory {

    private val nameFileDb="test.db"
    actual suspend fun createDriver(): SqlDriver {
        val sqlDriver=JdbcSqliteDriver(
            "jdbc:sqlite:file:$nameFileDb?cache=shared")
        Player.Schema.create(sqlDriver).await()
        return  sqlDriver
    }
}