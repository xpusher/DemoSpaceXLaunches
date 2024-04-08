package cleanArchitecturePlusSOLID.data

import app.cash.sqldelight.db.SqlDriver
import com.example.HockeyPlayer
import kotlinx.coroutines.flow.MutableStateFlow

//region SOLID -  OCP, LSP, ISP, DIP
interface Repository {
    val db:Db
    val network:Network
}
//endregion

//region SOLID - SRP
interface Db {
    val mutableSqlDriver: MutableStateFlow<SqlDriver?>
    suspend fun createDriver(): SqlDriver

    suspend fun addTestRecord()
    suspend fun readAllRecords():List<HockeyPlayer>
}

interface Network{
    fun testRequest()
}
//endregion