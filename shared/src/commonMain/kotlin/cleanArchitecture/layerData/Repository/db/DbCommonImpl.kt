package cleanArchitecture.layerData.Repository.db

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.db.SqlDriver
import com.example.Launch
import com.example.project.AppDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

abstract class DbCommonImpl: Db {

    private lateinit var appDb: AppDb

    private val mutableAppDb=MutableStateFlow<AppDb?>(null)

    private suspend fun waitDb(){
        mutableAppDb.takeWhile { mutableAppDb.value==null }.collectLatest {}
    }

    override val mutableSqlDriver = MutableStateFlow<SqlDriver?>(null)
    override suspend fun selectAllLaunchesInfo(): List<Launch> {
        waitDb()
        return appDb.appDbQueries.selectAllLaunchesInfo().awaitAsList()
    }
    override suspend fun insertLaunch(launch: Launch) {
        waitDb()
        appDb.appDbQueries.insertLaunch(
            flightNumber = launch.flightNumber,
            missionName = launch.missionName,
            details = launch.details,
            launchSuccess = launch.launchSuccess,
            launchDateUTC = launch.launchDateUTC,
            patchUrlSmall = launch.patchUrlSmall,
            patchUrlLarge = launch.patchUrlLarge,
            articleUrl = launch.articleUrl,
            timestamp = launch.timestamp
        )
    }

    override suspend fun removeAllLaunches() {
        waitDb()
        appDb.appDbQueries.removeAllLaunches()
    }
    init {

        CoroutineScope(Dispatchers.Default).launch {
            val sqlDriver=createDriver()
            mutableSqlDriver.value =sqlDriver
            appDb= AppDb(sqlDriver)
            mutableAppDb.value=appDb
        }

    }

}