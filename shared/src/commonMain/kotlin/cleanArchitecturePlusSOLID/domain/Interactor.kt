package cleanArchitecturePlusSOLID.domain

import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.usecase.UserActions

interface Interactor{
    val repository:Repository
    val presentation:Presentation
    val userActions:UserActions
}