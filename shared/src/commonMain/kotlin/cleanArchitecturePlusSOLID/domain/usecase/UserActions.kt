package cleanArchitecturePlusSOLID.domain.usecase

import kotlinx.coroutines.flow.MutableStateFlow

interface UserActions:TestSimpleButtonClick {

}
interface TestSimpleButtonClick{
    fun click()
}


