package cleanArchitecturePlusSOLID.domain

import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.Interactor

abstract class Domain(
     protected val presentation: Presentation) {
     abstract val interactor: Interactor
     protected abstract val repository:Repository
}