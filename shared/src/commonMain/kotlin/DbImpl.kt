import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.Db

expect class DbImpl: DbBaseImpl{
    override suspend fun createDriver(): SqlDriver
}