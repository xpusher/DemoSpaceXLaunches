package cleanArchitecturePlusSOLID.layerData.Repository.db

import app.cash.sqldelight.db.SqlDriver

expect class DbPlatformImpl: DbCommonImpl {
    override suspend fun createDriver(): SqlDriver
}