package cleanArchitecture.layerPresentation

import cleanArchitecture.layerDomain.entity.LaunchPresentation
import kotlinx.coroutines.flow.MutableStateFlow

class Presenter(val fontScale: Float = 1f) {

     var mutableLaunchesPresentation=
        MutableStateFlow<ArrayList<LaunchPresentation>?>(null)

}