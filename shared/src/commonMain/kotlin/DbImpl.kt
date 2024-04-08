import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.Db

expect class DbImpl: Db {
    suspend fun createDriver(): SqlDriver

}