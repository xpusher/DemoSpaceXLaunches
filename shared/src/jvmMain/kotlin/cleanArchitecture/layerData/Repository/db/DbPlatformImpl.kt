package cleanArchitecture.layerData.Repository.db

import DB_NAME_FILE
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.example.project.AppDb

actual class DbPlatformImpl: DbCommonImpl() {

    actual override suspend fun createDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver {
        val sqlDriver= JdbcSqliteDriver(
            "jdbc:sqlite:file:$DB_NAME_FILE?cache=shared"
        )
        AppDb.Schema.create(sqlDriver).await()
        return  sqlDriver
    }

}