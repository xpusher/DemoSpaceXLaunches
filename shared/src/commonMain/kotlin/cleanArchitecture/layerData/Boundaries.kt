package cleanArchitecture.layerData

import cleanArchitecture.layerData.Repository.Repository
import cleanArchitecture.nowUTC
import cleanArchitecture.toLaunch
import com.example.Launch
import kotlinx.datetime.LocalDateTime

class Boundaries(private val repository: Repository) {
    suspend fun requestLaunches(): List<Launch> {

        val db=repository.db

        val launches=ArrayList(db.selectAllLaunchesInfo())


        if (launches.size==0) {
            val timestamp=LocalDateTime.nowUTC()

            val rocketLaunches = repository.network.requestLaunches()

            rocketLaunches.forEach {
                val launch = it.toLaunch(timestamp)
                launches.add(launch)
                db.insertLaunch(launch)
            }
        }
        return launches
    }

    suspend fun clearDb(){
        repository.db.removeAllLaunches()
    }

}