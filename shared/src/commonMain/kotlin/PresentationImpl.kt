import cleanArchitecturePlusSOLID.Presentation.Presentation
import kotlinx.coroutines.flow.MutableStateFlow

class PresentationImpl: Presentation {

    override var mutableTestString=
        MutableStateFlow("00000000000")


}