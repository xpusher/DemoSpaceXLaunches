package cleanArchitecturePlusSOLID.data.db

import app.cash.sqldelight.db.SqlDriver
import com.example.Launch
import kotlinx.coroutines.flow.MutableStateFlow

interface Db {
    val mutableSqlDriver: MutableStateFlow<SqlDriver?>
    suspend fun createDriver(): SqlDriver
    suspend fun readAllRecords():List<Launch>

}