import cleanArchitecturePlusSOLID.domain.Interactor

actual class InteractorImpl: InteractorCommonImpl() {
    override val repository=RepositoryImpl()
}