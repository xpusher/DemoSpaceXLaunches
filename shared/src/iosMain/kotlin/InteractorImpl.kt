import cleanArchitecturePlusSOLID.Presentation.Presentation
import cleanArchitecturePlusSOLID.data.Repository
import cleanArchitecturePlusSOLID.domain.InteractorCommonImpl

actual class InteractorImpl(
    override val presentation: Presentation,
    override val repository: Repository
): InteractorCommonImpl(
    presentation,
    repository
)