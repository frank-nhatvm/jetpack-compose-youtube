package com.frank.jetpackcomposeyoutube.ui.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frank.jetpackcomposeyoutube.ui.theme.AppTheme
import com.frank.jetpackcomposeyoutube.ui.theme.appBlack

@Composable
fun CreateNewPasswordScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp).background(color = AppTheme.appColor.backgroundColor)
    ) {


        Text(
            "Create New Password",

        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Enter your new password. If you forget it, then you have to do forgot password.",
            style = AppTheme.appTypography.body
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = {

            })
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Remember me", style = AppTheme.appTypography.subTitle,

            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true,name = "Light Theme")
@Composable
fun CreateNewPasswordScreenPreview() {
    AppTheme(isDark = false) {
        CreateNewPasswordScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true,name = "DarK Theme")
@Composable
fun CreateNewPasswordScreenPreviewDark() {
    AppTheme(isDark = true) {
        CreateNewPasswordScreen()
    }
}