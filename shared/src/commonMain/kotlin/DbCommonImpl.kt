import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.Db
import com.example.Launch
import com.example.project.AppDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class DbCommonImpl: Db {

    lateinit var appDb: AppDb

    protected val nameFileDb="test.db"

    override val mutableSqlDriver = MutableStateFlow<SqlDriver?>(null)
    override suspend fun addTestRecord() {

    }

    override suspend fun readAllRecords(): List<Launch> {
        return appDb.appDbQueries.selectAllLaunchesInfo().awaitAsList()
    }

    init {
        CoroutineScope(Dispatchers.Default).launch {
            val sqlDriver=createDriver()
            mutableSqlDriver.value =sqlDriver
            appDb=AppDb(sqlDriver)
        }
    }

}