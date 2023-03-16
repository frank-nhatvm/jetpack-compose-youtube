package com.frank.jetpackcomposeyoutube.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

    Column {
        CartItem(title = "First card")
        Spacer(modifier = Modifier.height(12.dp))
        Surface(color = Color.Black, contentColor = MaterialTheme.colors.onError) {
            CartItem(title = "Surface card")
        }

        // surface: red
        // onsurface: white

        // text : black


        Surface(
            color = MaterialTheme.colors.surface,

        ) {

            Text("Warning", )
        }
    }
}


@Composable
fun CartItem(title: String) {
    Row {
        Icon(Icons.Default.Add, contentDescription = "")
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = title, style = MaterialTheme.typography.body1)
    }
}


@Preview(name = "preview", showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}