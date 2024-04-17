package cleanArchitecture.layerData.Repository.db

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import cleanArchitecture.layerDomain.entity.LaunchSerializable
import cleanArchitecture.toLaunch
import cleanArchitecture.toLaunchSerializable
import com.example.Launch
import com.example.project.AppDb
import kotlinx.browser.localStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement
import org.w3c.dom.Worker
import org.w3c.dom.get
import org.w3c.dom.set
import kotlin.js.Json

actual class DbPlatformImpl: DbCommonImpl() {

    actual override suspend fun createDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver {
        return WebWorkerDriver(
            Worker(
                js(
                    """new URL("sqljs.worker.js", import.meta.url)"""
                )
            )
        ).also {
            schema.create(it).await()
            val preloadAppDb=AppDb(it)
            val stringIndex= localStorage["index"]

            stringIndex?.let {
                val index: List<Long> =kotlinx.serialization.json.Json.decodeFromString<List<Long>>(stringIndex)
                index.forEach { valueIndex->
                    val valueIndexStr=valueIndex.toString()
                    val stringLaunch=localStorage[valueIndexStr]!!
                    stringLaunch.toString()
                    val launchSerializable=kotlinx.serialization.json.Json.decodeFromString<LaunchSerializable>(stringLaunch)
                    val launch=launchSerializable.toLaunch()
                    preloadAppDb.appDbQueries.insertLaunch(
                        launch.flightNumber,
                        launch.missionName,
                        launch.details,
                        launch.launchSuccess,
                        launch.launchDateUTC,
                        launch.patchUrlSmall,
                        launch.patchUrlLarge,
                        launch.articleUrl,
                        launch.timestamp
                    )
                }

            }

        }

    }

    init {
        CoroutineScope(Dispatchers.Unconfined).launch {
            waitDb()
            appDb.appDbQueries.selectAllLaunchesInfo().addListener {
                CoroutineScope(Dispatchers.Unconfined).launch {
                    val launches = appDb.appDbQueries.selectAllLaunchesInfo().awaitAsList()
                    val index = ArrayList<Long>()
                    launches.forEach {
                        index.add(it.flightNumber)
                        localStorage[it.flightNumber.toString()] = kotlinx.serialization.json.Json.Default.encodeToJsonElement(it.toLaunchSerializable()).toString()
                    }

                    localStorage["index"] = kotlinx.serialization.json.Json.Default.encodeToJsonElement(index).toString()
                }
            }

        }
    }
}