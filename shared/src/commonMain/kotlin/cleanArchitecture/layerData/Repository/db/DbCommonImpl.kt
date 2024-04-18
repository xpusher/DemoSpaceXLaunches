package cleanArchitecture.layerData.Repository.db

import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.db.SqlDriver
import com.example.Launch
import com.example.project.AppDb
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class DbCommonImpl: Db {
    private lateinit var _appDb: AppDb
    private val mutex=Mutex()
    private suspend  fun appDb(): AppDb = mutex.withLock{
        if (!::_appDb.isInitialized) {
            _appDb = AppDb(createDriver(AppDb.Schema))
            onCreateDriver(_appDb)
        }
        return _appDb
    }

    override  suspend fun onCreateDriver(appDb: AppDb) {
    }

    override val mutableSqlDriver = MutableStateFlow<SqlDriver?>(null)
    override suspend fun selectAllLaunchesInfo(): List<Launch> {
        return appDb().appDbQueries.selectAllLaunchesInfo().awaitAsList()
    }
    override suspend fun insertLaunch(launch: Launch) {
            appDb().appDbQueries.insertLaunch(
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
        appDb().appDbQueries.removeAllLaunches()
    }
    override suspend fun removeLaunchesByFlightNumber(flightNumber: Long) {
        appDb().appDbQueries.removeLaunchesByFlightNumber(listOf(flightNumber))
    }


}