import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.project.Player

actual class DriverFactory(private val context: Context){
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(Player.Schema, context, "test.db")
    }

}