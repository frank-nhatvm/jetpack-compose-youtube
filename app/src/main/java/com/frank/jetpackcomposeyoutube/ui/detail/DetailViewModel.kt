package com.frank.jetpackcomposeyoutube.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {

    private var _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Default)
    val uiState: StateFlow<DetailUiState>
    get() = _uiState

    init {
        Log.e("Frank","DetailViewModel init")
    }

    fun handleAction(action: DetailUiAction){
        Log.e("Frank","DetailViewModel handleAction ${action.javaClass.name}")
        if(action is DetailUiAction.FetchData){
            fetchData(action.time)
        }
    }

    private fun fetchData(time: Long) {
        viewModelScope.launch {
            _uiState.value = DetailUiState.Loading
            Log.e("Frank", "fetchData start $time")
            delay(4000L)
            Log.e("Frank", "fetchData end ${System.currentTimeMillis()}")
            _uiState.value = DetailUiState.Success(data = "Success $time")
        }
    }
}

sealed class DetailUiState{
    object Default: DetailUiState()
    object Loading: DetailUiState()
    data class Success(val data:String) : DetailUiState()
    data class Error(val msg: String): DetailUiState()
}

sealed class DetailUiAction{
    data class FetchData(val time: Long): DetailUiAction()

}

