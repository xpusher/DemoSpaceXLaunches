import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(fontScale:Float=1f,content: @Composable () -> Unit){



    MaterialTheme(
        content = content,
        typography = MaterialTheme.typography.copy(
            body1 = MaterialTheme.typography.body1.copy(
                fontSize = MaterialTheme.typography.body1.fontSize.times(fontScale),
                lineHeight = MaterialTheme.typography.body1.lineHeight.times(fontScale)
            ),
            body2 = MaterialTheme.typography.body2.copy(
                fontSize = MaterialTheme.typography.body2.fontSize.times(fontScale),
                lineHeight = MaterialTheme.typography.body2.lineHeight.times(fontScale)
            ),
            subtitle2 = MaterialTheme.typography.subtitle2.copy(
                fontSize = MaterialTheme.typography.subtitle2.fontSize.times(fontScale),
                lineHeight = MaterialTheme.typography.subtitle2.lineHeight.times(fontScale)
            ),

            )
        )

}

