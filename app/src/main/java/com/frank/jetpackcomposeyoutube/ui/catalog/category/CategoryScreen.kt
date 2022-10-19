package com.frank.jetpackcomposeyoutube.ui.catalog.category

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryScreen(openProductDetail:(String)->Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {
        Text(text = "Category Screen")
        Spacer(modifier = Modifier.height(24.dp))

        var productId by rememberSaveable {
            mutableStateOf("")
        }
        OutlinedTextField(value = productId, onValueChange = {
            productId = it
        }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { openProductDetail(productId) }) {
            Text("Open Product Detail")
        }
    }
}