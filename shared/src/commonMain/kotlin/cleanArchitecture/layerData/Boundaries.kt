package cleanArchitecture.layerData

import cleanArchitecture.layerData.Repository.Repository
import cleanArchitecture.layerDomain.entity.RocketLaunch
import cleanArchitecture.toLaunch
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