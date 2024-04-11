package cleanArchitecturePlusSOLID.layerPresentation

import cleanArchitecturePlusSOLID.layerDomain.entity.RocketLaunch
import kotlinx.coroutines.flow.MutableStateFlow

interface Presentation {
    var mutableTestString: MutableStateFlow<String?>
    var mutableRocketLaunches: MutableStateFlow<List<RocketLaunch>>
}