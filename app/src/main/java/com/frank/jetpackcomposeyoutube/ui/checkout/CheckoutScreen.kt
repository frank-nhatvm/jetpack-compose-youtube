package com.frank.jetpackcomposeyoutube.ui.checkout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckoutScreen(cartId: String, customerId: String){
 Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {

     Text("Processing cart with id: $cartId for customer with id: $customerId")

 }
}