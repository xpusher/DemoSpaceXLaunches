package cleanArchitecture.layerDomain.usecase

interface UserActions: DbActions {

}
interface DbActions{
    fun hardUpdateLaunches()
    fun softUpdateLaunches()
    fun removeLaunches(flightNumber:Long)
}


