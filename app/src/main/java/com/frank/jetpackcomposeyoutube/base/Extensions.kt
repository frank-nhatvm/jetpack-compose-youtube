package com.frank.jetpackcomposeyoutube.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun <T>NavController.GetResultOneTime(key:String,onResult:(T?)->Unit){
    val valueScreenResult =  currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData<T>(key)?.observeAsState()

    onResult(valueScreenResult?.value)
    currentBackStackEntry
        ?.savedStateHandle
        ?.remove<T>(key)
}