package com.frank.jetpackcomposeyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.frank.jetpackcomposeyoutube.ui.theme.JetpackComposeYoutubeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeYoutubeTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {

    var currentScreen by remember {
        mutableStateOf(Screen.VideoDetailScreen)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        if (currentScreen == Screen.VideoDetailScreen) {
            VideoDetailScreen() {
                currentScreen = Screen.CategoryScreen
            }
        } else {
            CategoryScreen()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeYoutubeTheme {
        MainApp()
    }
}

enum class Screen {
    VideoDetailScreen,
    CategoryScreen
}