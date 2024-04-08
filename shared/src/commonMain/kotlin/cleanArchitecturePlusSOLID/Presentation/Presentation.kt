package cleanArchitecturePlusSOLID.Presentation

import kotlinx.coroutines.flow.MutableStateFlow

interface Presentation {
    var mutableTestString: MutableStateFlow<String>
}