package com.frank.jetpackcomposeyoutube

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frank.jetpackcomposeyoutube.ui.theme.JetpackComposeYoutubeTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {

    LazyVerticalGrid(cells = GridCells.Fixed(2),
    horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp)
    ) {

        items(20) { index ->
        Item(index = index)
        }

    }


}


@Composable
fun Item(modifier: Modifier = Modifier, index : Int){
    Box(
        modifier = Modifier
            .background(
                color = Color.Magenta,
                shape = RoundedCornerShape(12.dp)
            )
            .aspectRatio(1f)
            .clip(RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ){
        Text("$index", style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ))
    }
}

//@Composable
//@Preview(name = "Item Preview")
//fun ItemPreview(){
//    Item(index = 20)
//}

@Composable
@Preview(name = "Category Screen Preview", showBackground = true, showSystemUi = true)
fun CategoryScreenPreview() {
    JetpackComposeYoutubeTheme {
        CategoryScreen()
    }
}