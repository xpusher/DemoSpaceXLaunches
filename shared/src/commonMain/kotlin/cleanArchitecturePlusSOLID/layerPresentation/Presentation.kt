package cleanArchitecturePlusSOLID.layerPresentation

import kotlinx.coroutines.flow.MutableStateFlow

class Presentation{

     var mutableTestString: MutableStateFlow<String?> =
        MutableStateFlow("00000000000")

     var mutableLaunchesPresentation=
        MutableStateFlow<List<LaunchPresentation>>(listOf())

}