import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.db.DbCommonImpl

expect class DbImpl: DbCommonImpl {
    override suspend fun createDriver(): SqlDriver
}