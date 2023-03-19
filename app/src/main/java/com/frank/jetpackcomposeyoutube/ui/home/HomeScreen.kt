package com.frank.jetpackcomposeyoutube.ui.home

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope

@Composable
fun HomeScreen(
    onNavigateRegisterScreen: () -> Unit
) {



    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = Color.Yellow)

    var count by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Stupid challenge")
        Spacer(modifier = Modifier.height(4.dp))
        Text("Welcome. To register click in here 3 times")

        Spacer(modifier = Modifier.height(24.dp))

        if (count >= 3) {

            RegisterButton {
                onNavigateRegisterScreen()
            }
            Spacer(modifier = Modifier.height(24.dp))

        } else {
            ChallengeButton(onClick = {
                count++
            }, count = count)
            FunIcon(count = count)
        }
    }
}


@Composable
fun ChallengeButton(
    onClick: () -> Unit,
    count: Int
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick =
            onClick
        ) {
            Text(text = "$count")
        }
    }


}

@Composable
fun RegisterButton(
    onRegister: () -> Unit
) {
    Button(onClick = onRegister) {
        Text(text = "Register now")
    }

}

@Composable
fun FunIcon(
    count: Int
) {
    // call function of class A state count (
    val list = listOf("\uD83E\uDD14", "\uD83E\uDD27", "\uD83D\uDE0E")

    var icon by remember(count) {
        mutableStateOf("\uD83E\uDEE3")
    }

    icon = if (count >= list.size) {
        list.random()
    } else {
        list[count]
    }

    Log.e("Frank", "Funico Recomposition")

    Column() {
        Text(text = icon, fontSize = 80.sp)
        Spacer(modifier = Modifier.height(24.dp))
    }


    // --> composition >> state changed >> recompositon >>
    LaunchedEffect(key1 = Unit) {
        // function
        // viewModel.fetchData productdetail
        // ex code coroutine scope
        Log.e("Frank", "FunIcon LaunchedEffect Unit")
    }

    LaunchedEffect(key1 = true) {
        Log.e("Frank", "FunIcon LaunchedEffect true")
    }

    // key : state
    LaunchedEffect(key1 = count, ) {
        //
        Log.e("Frank", "FunIcon LaunchedEffect count $count")
    }

    DisposableEffect(Unit) {
        Log.e("Frank", "FunIcon DisposableEffect Unit")
        onDispose {
            Log.e("Frank", "FunIcon DisposableEffect Unit onDispose")
        }
    }

// true unit >> composable ( FunIcon ) << remove
    DisposableEffect(true) {
        Log.e("Frank", "FunIcon DisposableEffect true")
        // broad

        onDispose {

            Log.e("Frank", "FunIcon DisposableEffect true onDispose")
        }
    }
// key state 0 1 2

// count 0 >> count 1
  // onDispone 0 >> ... 1
    DisposableEffect(count) {
        Log.e("Frank", "FunIcon DisposableEffect count $count")

        // register event 1
        onDispose {
            Log.e("Frank", "FunIcon DisposableEffect count $count onDispose")
            // clean event 0
        }
    }

    Log.e("Frank", "Funico Recomposition final")
}


