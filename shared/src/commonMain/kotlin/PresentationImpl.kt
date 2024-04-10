import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.domain.entity.RocketLaunch
import kotlinx.coroutines.flow.MutableStateFlow

class PresentationImpl: Presentation {

    override var mutableTestString: MutableStateFlow<String?> =
        MutableStateFlow("00000000000")

    override var mutableRocketLaunches=
        MutableStateFlow<List<RocketLaunch>>(listOf())

}