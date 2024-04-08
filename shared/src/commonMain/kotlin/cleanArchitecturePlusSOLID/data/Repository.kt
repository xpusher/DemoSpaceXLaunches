package cleanArchitecturePlusSOLID.data

import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.flow.MutableStateFlow

//region SOLID -  OCP, LSP, ISP, DIP
interface Repository {
    val db:Db
}
//endregion

//region SOLID - SRP
interface Db {
    val mutableSqlDriver: MutableStateFlow<SqlDriver?>
    suspend fun createDriver(): SqlDriver
}
//endregion