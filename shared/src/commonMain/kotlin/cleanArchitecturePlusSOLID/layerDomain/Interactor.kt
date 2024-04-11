package cleanArchitecturePlusSOLID.layerDomain

import cleanArchitecturePlusSOLID.layerPresentation.Presentation
import cleanArchitecturePlusSOLID.layerData.Repository.Repository
import cleanArchitecturePlusSOLID.layerDomain.usecase.UserActions

abstract class Interactor{
    protected abstract val repository: Repository
    protected abstract val presentation:Presentation
    abstract val userActions:UserActions
}