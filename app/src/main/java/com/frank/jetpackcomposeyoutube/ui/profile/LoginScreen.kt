package com.frank.jetpackcomposeyoutube.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frank.jetpackcomposeyoutube.ui.component.OtpInputField


@Composable
fun LoginScreen() {

    var otpValue by remember {
        mutableStateOf("")
    }

    val isEnableButton = derivedStateOf {
        otpValue.length == 6
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(text = "Login with your pin", style = MaterialTheme.typography.h3)

        Spacer(modifier = Modifier.height(24.dp))

        val currentShape = MaterialTheme.shapes.copy(small = RoundedCornerShape(50))
        val typography = MaterialTheme.typography.copy(
            h4 = TextStyle(
                fontSize = 12.sp
            )
        )

        val currentColor = MaterialTheme.colors.copy(primary = Color.Magenta)

        MaterialTheme(
            shapes = currentShape,
            colors = currentColor,
            typography = typography
        ) {
            OtpInputField(otpLength = 6, onOtpChanged = { otp ->
                otpValue = otp
            })
        }



        Spacer(modifier = Modifier.height(48.dp))
        Button(onClick = {

        }, enabled = isEnableButton.value) {
            Text("Login")
        }
    }

}