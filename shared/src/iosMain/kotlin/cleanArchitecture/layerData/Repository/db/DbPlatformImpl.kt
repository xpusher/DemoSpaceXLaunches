package cleanArchitecture.layerData.Repository.db

import DB_NAME_FILE
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.project.AppDb

actual class DbPlatformImpl: DbCommonImpl() {

    actual override suspend fun createDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver {
        val sqlDriver=
            NativeSqliteDriver(
                AppDb.Schema.synchronous(), DB_NAME_FILE
            )

        //Player.Schema.create(sqlDriver).await()

        return sqlDriver
    }

}