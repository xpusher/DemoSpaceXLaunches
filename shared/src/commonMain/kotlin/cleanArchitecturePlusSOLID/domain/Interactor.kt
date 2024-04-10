package cleanArchitecturePlusSOLID.domain

import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.usecase.UserActions

abstract class Interactor{
    protected abstract val repository:Repository
    protected abstract val presentation:Presentation
    abstract val userActions:UserActions
}