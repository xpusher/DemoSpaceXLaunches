import android.content.Context

actual class InteractorImpl(context: Context): InteractorCommonImpl() {
    override val repository=RepositoryImpl(context)
}