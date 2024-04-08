
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import cleanArchitecturePlusSOLID.data.Db
import com.example.project.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.w3c.dom.Worker

actual class DbImpl: Db {
    override val mutableSqlDriver = MutableStateFlow<SqlDriver?>(null)

    actual suspend fun createDriver(): SqlDriver {
        val sqlDriver=WebWorkerDriver(
            Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            ))
            Player.Schema.create(sqlDriver).await()
        return sqlDriver

    }

    init {
        CoroutineScope(Dispatchers.Default).launch {
            mutableSqlDriver.value=DbImpl().createDriver()
        }
    }

}