import app.cash.sqldelight.async.coroutines.awaitAsList
import app.cash.sqldelight.async.coroutines.awaitAsOne
import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.Db
import com.example.HockeyPlayer
import com.example.project.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class DbBaseImpl: Db {

    lateinit var player: Player

    override val mutableSqlDriver = MutableStateFlow<SqlDriver?>(null)
    override suspend fun addTestRecord() {

        player.playerQueries.insert(
            (player.playerQueries.selectCount().awaitAsOne() + 1),
            "QQQ")

    }

    override suspend fun readAllRecords(): List<HockeyPlayer> {
        return player.playerQueries.selectAll().awaitAsList()
    }

    init {
        CoroutineScope(Dispatchers.Default).launch {
            val sqlDriver=createDriver()
            mutableSqlDriver.value =sqlDriver
            player=Player(sqlDriver)
        }
    }

}