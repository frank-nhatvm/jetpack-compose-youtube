package com.frank.jetpackcomposeyoutube.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(openCategoryAction: () -> Unit, openMyAccountScreen: () -> Unit,editCustomerInfo: ()->Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Screen")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { openCategoryAction() }) {
            Text("Open Category")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            openMyAccountScreen()
        }) {
            Text(text = "Open MyAccount")
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            editCustomerInfo()
        }) {
            Text(text = "Edit customer information")
        }
    }
}