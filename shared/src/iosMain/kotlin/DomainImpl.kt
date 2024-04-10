import cleanArchitecturePlusSOLID.domain.Domain
import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.Interactor

actual class DomainImpl(presentation: Presentation): Domain(presentation) {

    override val repository: Repository =
        RepositoryImpl()

    override val interactor: Interactor =
        InteractorImpl(presentation,repository)
}