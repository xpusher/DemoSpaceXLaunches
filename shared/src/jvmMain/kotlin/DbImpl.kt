import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import cleanArchitecturePlusSOLID.data.Db
import com.example.project.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

actual class DbImpl: DbBaseImpl() {

    private val nameFileDb="test.db"
    actual override suspend fun createDriver(): SqlDriver {
        val sqlDriver=JdbcSqliteDriver(
            "jdbc:sqlite:file:$nameFileDb?cache=shared")
        Player.Schema.create(sqlDriver).await()
        return  sqlDriver
    }

}