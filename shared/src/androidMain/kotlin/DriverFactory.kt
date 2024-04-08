import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.project.Player

actual class DriverFactory(private val context: Context){
    actual suspend fun createDriver(): SqlDriver {
        val sqlDriver=AndroidSqliteDriver(
            schema = Player.Schema.synchronous(),
            context = context,
            callback = object :AndroidSqliteDriver.Callback(Player.Schema.synchronous()){},
            name = "test.db")
        Player.Schema.create(sqlDriver).await()
        return sqlDriver
    }

}