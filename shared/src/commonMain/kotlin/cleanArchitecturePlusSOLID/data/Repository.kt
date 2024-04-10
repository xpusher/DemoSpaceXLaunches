package cleanArchitecturePlusSOLID.data

import app.cash.sqldelight.db.SqlDriver
import cleanArchitecturePlusSOLID.data.db.Db
import cleanArchitecturePlusSOLID.data.network.Network
import cleanArchitecturePlusSOLID.domain.entity.RocketLaunch
import com.example.Launch
import kotlinx.coroutines.flow.MutableStateFlow

//region SOLID -  OCP, LSP, ISP, DIP
interface Repository {
    val db: Db
    val network: Network
}
//endregion

//region SOLID - SRP


//endregion