import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.success
import kotlinproject.composeapp.generated.resources.unsuccessful
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

@Composable
fun textStyleBoolColorPresentation(boolean: Boolean):TextStyle{
    return LocalTextStyle.current.copy(color=
        if (boolean) Color.Green else Color.Red)
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun textBoolPresentation(boolean: Boolean):String{
    return if (boolean) stringResource(Res.string.success) else stringResource(Res.string.unsuccessful)
}