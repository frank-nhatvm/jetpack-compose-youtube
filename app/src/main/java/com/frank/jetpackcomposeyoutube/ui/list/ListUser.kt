package com.frank.jetpackcomposeyoutube.ui.list

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frank.jetpackcomposeyoutube.ui.component.BaseScreen


@Composable
fun ListScreen() {

//    val scrollController =
    val state = rememberLazyListState()

    val list = (0..100).toList()
    val isShow by remember {
        derivedStateOf {
            Log.e("Frank","ListScreen calculate isShow")
            state.firstVisibleItemIndex > 1 }
    }




    Column {
        if(isShow) {
            SortFilter()
        }
        LazyColumn(state = state) {
            items(list, key = { index -> index }) { index ->
                Text(
                    "Item $index", modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                )
            }
        }
    }


}

@Composable
fun SortFilter() {
    Log.e("Frank","SORT FIlter Resomposition firstIndex ")
    //if(firstIndex > 1) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)) {
            Text("Sort")
            Text(text = "Filter")
        }
   // }
}

