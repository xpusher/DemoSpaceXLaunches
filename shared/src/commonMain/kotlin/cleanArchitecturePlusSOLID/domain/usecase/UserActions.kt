package cleanArchitecturePlusSOLID.domain.usecase

import kotlinx.coroutines.flow.MutableStateFlow

interface UserActions:TestRequestKtor {

}
interface TestRequestKtor{

    var mutableTestString:MutableStateFlow<String>
    fun testRequestKtor()
}

