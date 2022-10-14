package com.frank.jetpackcomposeyoutube

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.frank.jetpackcomposeyoutube.ui.theme.JetpackComposeYoutubeTheme


@Composable
fun CategoryScreen(modifier: Modifier = Modifier){

}

@Composable
@Preview(name = "Category Screen Preview", showBackground =  true, showSystemUi = true)
fun CategoryScreenPreview(){
    JetpackComposeYoutubeTheme {
        CategoryScreen()
    }
}