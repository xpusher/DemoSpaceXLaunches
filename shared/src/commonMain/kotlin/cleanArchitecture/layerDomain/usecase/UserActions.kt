package cleanArchitecture.layerDomain.usecase

interface UserActions: TestSimpleButtonClick {

}
interface TestSimpleButtonClick{
    fun updateLaunches()
    fun loadLaunches()
}


