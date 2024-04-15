package cleanArchitecture.layerData.Repository.db

import app.cash.sqldelight.db.SqlDriver
import com.example.Launch
import kotlinx.coroutines.flow.MutableStateFlow

interface Db {
    val mutableSqlDriver: MutableStateFlow<SqlDriver?>
    suspend fun createDriver(): SqlDriver
    suspend fun selectAllLaunchesInfo():List<Launch>
    suspend fun insertLaunch(launch:Launch)
    suspend fun removeAllLaunches()
    suspend fun removeLaunchesByFlightNumber(flightNumber:Long)

}