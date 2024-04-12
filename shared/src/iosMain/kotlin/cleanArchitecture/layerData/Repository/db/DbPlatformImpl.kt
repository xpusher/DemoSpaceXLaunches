package cleanArchitecture.layerData.Repository.db

import DB_NAME_FILE
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.project.AppDb

actual class DbPlatformImpl: DbCommonImpl() {

    actual override suspend fun createDriver(): SqlDriver {
        val sqlDriver=
            NativeSqliteDriver(
                AppDb.Schema.synchronous(), DB_NAME_FILE
            )

        //Player.Schema.create(sqlDriver).await()

        return sqlDriver
    }

}