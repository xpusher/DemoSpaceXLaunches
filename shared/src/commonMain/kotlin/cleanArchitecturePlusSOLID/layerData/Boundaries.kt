package cleanArchitecturePlusSOLID.layerData

import cleanArchitecturePlusSOLID.layerData.Repository.Repository
import cleanArchitecturePlusSOLID.layerDomain.entity.RocketLaunch
import cleanArchitecturePlusSOLID.toLaunch
import com.example.Launch

class Boundaries(private val repository: Repository) {
    suspend fun testRequest(): List<Launch> {
        //val rocketLaunches=repository.db.readAllRecords()
        val rocketLaunches=repository.network.testRequest()
        val launches=ArrayList<Launch>()
        rocketLaunches.forEach {
            launches.add(it.toLaunch())
        }
        return launches
    }
}