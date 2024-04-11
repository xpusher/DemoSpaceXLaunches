package cleanArchitecturePlusSOLID.layerPresentation

import cleanArchitecturePlusSOLID.layerDomain.entity.RocketLaunch
import kotlinx.coroutines.flow.MutableStateFlow

class PresentationImpl: Presentation {

    override var mutableTestString: MutableStateFlow<String?> =
        MutableStateFlow("00000000000")

    override var mutableRocketLaunches=
        MutableStateFlow<List<RocketLaunch>>(listOf())

}