package com.frank.jetpackcomposeyoutube.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

// color : warning   onWarning

data class AppColorWarning(
    val  warning: Color = Color.Unspecified,
    val onWarning: Color  = Color.Unspecified
)

val LocalAppColorWarning = staticCompositionLocalOf {
    AppColorWarning()
}

private val customTypography = Typography(
    body1 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif
    )
)


@Composable
fun JetpackComposeYoutubeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {


    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val appColorWarning = if(darkTheme){
        AppColorWarning(warning = Color.Magenta, onWarning = Color.White)
    }else{
        AppColorWarning(warning = Color.Blue, onWarning = Color.Yellow)
    }

    CompositionLocalProvider(LocalAppColorWarning provides appColorWarning) {
        MaterialTheme(
            colors = colors,
            typography = customTypography,
            shapes = Shapes,
            content = content
        )
    }

}

object JetpackComposeYoutubeTheme{
    val appColorWarning: AppColorWarning
    @Composable
    get() = LocalAppColorWarning.current
}