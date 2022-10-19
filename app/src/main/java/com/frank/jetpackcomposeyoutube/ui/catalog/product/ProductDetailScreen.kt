package com.frank.jetpackcomposeyoutube.ui.catalog.product

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailScreen(productId: String,checkout: (String,String)->Unit){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {
        Text("Product with id : $productId")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            checkout("224","9988")
        }) {
            Text("Checkout")
        }
    }

}