package cleanArchitecturePlusSOLID.layerPresentation

import cleanArchitecturePlusSOLID.layerDomain.entity.RocketLaunch
import com.example.Launch
import kotlinx.coroutines.flow.MutableStateFlow

class Presentation{

     var mutableTestString: MutableStateFlow<String?> =
        MutableStateFlow("00000000000")

     var mutableRocketLaunches=
        MutableStateFlow<List<Launch>>(listOf())

}