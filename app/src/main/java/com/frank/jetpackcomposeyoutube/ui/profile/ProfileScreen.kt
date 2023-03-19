package com.frank.jetpackcomposeyoutube.ui.profile

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.frank.jetpackcomposeyoutube.ui.component.BaseScreen

@Composable
fun ProfileRoute(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    userName: String,
    onBack: () -> Unit
) {
    val uiState = profileViewModel.uiState.collectAsState()
    Log.e("Frank", "ProfileRoute ${uiState.value.javaClass.name}")


    when (uiState.value) {
        ProfileUiState.Default -> {
            LaunchedEffect(true) {
                profileViewModel.init()
            }
        }
        ProfileUiState.SaveProfileSuccess -> {
            LaunchedEffect(true) {
                Log.e("Frank", "ProfileRoute back")
                onBack()
            }
        }
    }

    BaseScreen(titleScreen = "Profile") {
        ProfileScreen(userName = userName) {
            profileViewModel.saveProfile()
        }
    }
    BackHandler() {
        onBack()
    }
}

@Composable
fun ProfileScreen(userName: String, onSave: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(userName)
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(value = "", onValueChange = {})

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onSave) {
            Text("Save")
        }

    }

}