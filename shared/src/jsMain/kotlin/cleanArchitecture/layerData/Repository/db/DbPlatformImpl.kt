package cleanArchitecture.layerData.Repository.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import com.example.project.AppDb
import org.w3c.dom.Worker

actual class DbPlatformImpl: DbCommonImpl() {

    actual override suspend fun createDriver(): SqlDriver {
        val sqlDriver= WebWorkerDriver(
            Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            )
        )
            AppDb.Schema.create(sqlDriver).await()
        return sqlDriver

    }

}