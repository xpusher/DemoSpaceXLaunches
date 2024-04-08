import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.project.Player

actual class DriverFactory(private val context: Context){
    actual fun createDriver(): SqlDriver {
        //return AndroidSqliteDriver(Player.Schema, context, "test.db")
        return AndroidSqliteDriver(
            schema = Player.Schema.synchronous(),
            context = context,
            callback = object :AndroidSqliteDriver.Callback(Player.Schema.synchronous()){},
            name = "test.db")
    }

}