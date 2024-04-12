package cleanArchitecture.layerData

import cleanArchitecture.layerData.Repository.Repository
import cleanArchitecture.toLaunch
import com.example.Launch

class Boundaries(private val repository: Repository) {
    suspend fun testRequest(): List<Launch> {
        val db=repository.db

        val launches=ArrayList(db.selectAllLaunchesInfo())

        if (launches.size==0) {
            val rocketLaunches = repository.network.requestLaunches()

            rocketLaunches.forEach {
                val launch = it.toLaunch()
                launches.add(launch)
                db.insertLaunch(launch)
            }
        }
        return launches
    }
}