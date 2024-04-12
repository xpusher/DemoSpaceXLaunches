package cleanArchitecture.layerData.Repository.db

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.db.SqlDriver
import com.example.Launch
import com.example.project.AppDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class DbCommonImpl: Db {

    private lateinit var appDb: AppDb

    override val mutableSqlDriver = MutableStateFlow<SqlDriver?>(null)
    override suspend fun selectAllLaunchesInfo(): List<Launch> {
        return appDb.appDbQueries.selectAllLaunchesInfo().awaitAsList()
    }
    override suspend fun insertLaunch(launch: Launch) {
        appDb.appDbQueries.insertLaunch(
            flightNumber = launch.flightNumber,
            missionName = launch.missionName,
            details = launch.details,
            launchSuccess = launch.launchSuccess,
            launchDateUTC = launch.launchDateUTC,
            patchUrlSmall = launch.patchUrlSmall,
            patchUrlLarge = launch.patchUrlLarge,
            articleUrl = launch.articleUrl

        )
    }

    override suspend fun removeAllLaunches() {
        appDb.appDbQueries.removeAllLaunches()
    }
    init {
        CoroutineScope(Dispatchers.Default).launch {
            val sqlDriver=createDriver()
            mutableSqlDriver.value =sqlDriver
            appDb= AppDb(sqlDriver)
        }
    }

}