package com.frank.jetpackcomposeyoutube.ui.profile


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
class ProfileViewModel @Inject constructor(): ViewModel() {

    private var _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Default)
    val uiState: StateFlow<ProfileUiState>
        get() = _uiState

    fun init(){
        viewModelScope.launch {
            Log.e("Frank","ProfileViewModel init")
        }
    }

    fun saveProfile() {
        viewModelScope.launch {
            delay(1000)
            _uiState.value = ProfileUiState.SaveProfileSuccess
        }
    }

}

sealed interface ProfileUiState {
    object SaveProfileSuccess: ProfileUiState
    object Default: ProfileUiState
}

