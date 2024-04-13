package cleanArchitecture.layerPresentation

import cleanArchitecture.layerDomain.entity.LaunchPresentation
import kotlinx.coroutines.flow.MutableStateFlow

class Presentation{

     var mutableTestString: MutableStateFlow<String?> =
        MutableStateFlow("00000000000")

     var mutableLaunchesPresentation=
        MutableStateFlow<List<LaunchPresentation>?>(null)

}