package cleanArchitecture.layerData

import cleanArchitecture.layerData.Repository.Repository
import cleanArchitecture.nowUTC
import cleanArchitecture.toLaunch
import com.example.Launch
import kotlinx.datetime.LocalDateTime

class Boundaries(private val repository: Repository) {
    suspend fun networkRequestLaunches(): List<Launch> {

        val launches=ArrayList<Launch>()

        val timestamp=LocalDateTime.nowUTC()

        val rocketLaunches = repository.network.requestLaunches()

        rocketLaunches.forEach {
            launches.add(it.toLaunch(timestamp))
        }

        return launches
    }
    suspend fun dbClearLaunches(){
        repository.db.removeAllLaunches()
    }
    suspend fun dbRemoveLaunchesByFlightNumber(flightNumber:Long){
        repository.db.removeLaunchesByFlightNumber(flightNumber)
    }
    suspend fun dbLoadLaunches():List<Launch>{
        return repository.db.selectAllLaunchesInfo()
    }

    suspend fun dbInsertLaunch(launch: Launch){
        repository.db.insertLaunch(launch)
    }

}