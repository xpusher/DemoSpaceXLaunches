import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import cleanArchitecturePlusSOLID.data.db.DbCommonImpl
import com.example.project.AppDb

actual class DbImpl: DbCommonImpl() {

    actual override suspend fun createDriver(): SqlDriver {
        val sqlDriver=
            NativeSqliteDriver(
                AppDb.Schema.synchronous(), nameFileDb)

        //Player.Schema.create(sqlDriver).await()

        return sqlDriver
    }

}