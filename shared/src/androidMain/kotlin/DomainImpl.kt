import android.content.Context
import cleanArchitecturePlusSOLID.domain.Domain
import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.Interactor

actual class DomainImpl(context: Context, presentation: Presentation): Domain(presentation) {


    override val repository: Repository=
        RepositoryImpl(context)

    override val interactor: Interactor =
        InteractorImpl(presentation,repository)

}