import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import cleanArchitecturePlusSOLID.data.db.DbCommonImpl
import com.example.project.AppDb

actual class DbImpl: DbCommonImpl() {

    actual override suspend fun createDriver(): SqlDriver {
        val sqlDriver=JdbcSqliteDriver(
            "jdbc:sqlite:file:$nameFileDb?cache=shared")
        AppDb.Schema.create(sqlDriver).await()
        return  sqlDriver
    }

}