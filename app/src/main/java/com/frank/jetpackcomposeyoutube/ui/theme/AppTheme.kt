package com.frank.jetpackcomposeyoutube.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// largeTitle
// title
// subtitle
// body

data class AppTypography(
    val largeTitle: TextStyle = TextStyle.Default,
    val title: TextStyle = TextStyle.Default,
    val subTitle: TextStyle= TextStyle.Default,
    val body: TextStyle= TextStyle.Default,
)

data class AppColor(
    val textBodyColor: Color = Color(0xFF212121),
    val backgroundColor : Color = Color.Unspecified
)

data class AppShape(val smallShape: Shape)

data class AppSpacing(val smallSpacing: Dp = 12.dp)

val LocalAppTypography = staticCompositionLocalOf {
    AppTypography()
}

val LocalAppColor = staticCompositionLocalOf {
    AppColor()
}

@Composable
fun AppTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val typography = AppTypography(
        largeTitle =  TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        ),
        title = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        ),
        subTitle = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        ),
        body = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
        )
    )

    val appColor =  if(isDark){
        AppColor(
            textBodyColor = Color.White,
            backgroundColor = Color.Black
        )
    }
    else {
         AppColor(
            textBodyColor = Color.Black,
            backgroundColor = Color.White
        )
    }

    CompositionLocalProvider(LocalAppTypography provides typography, LocalAppColor provides appColor) {
        content.invoke()
    }
}

object AppTheme{
    val appTypography: AppTypography
    @Composable
    get() = LocalAppTypography.current


    val appColor : AppColor
    @Composable
    get() = LocalAppColor.current
}