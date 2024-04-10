import app.cash.sqldelight.db.SqlDriver

expect class DbImpl: DbCommonImpl{
    override suspend fun createDriver(): SqlDriver
}