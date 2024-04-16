package cleanArchitecture.layerData.Repository.db

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import com.example.project.AppDb
import org.w3c.dom.Worker

actual class DbPlatformImpl: DbCommonImpl() {

    actual override suspend fun createDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver {



        return WebWorkerDriver(
            Worker(
                js("""
                        new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url);
                    """)
            )
        ).also { schema.create(it).await() }

    }

}