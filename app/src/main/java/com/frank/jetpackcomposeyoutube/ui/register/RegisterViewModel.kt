package com.frank.jetpackcomposeyoutube.ui.register

import android.util.Log
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    private var _uiState = MutableStateFlow<RegisterUiState>(RegisterUiState.Default)
    val uiState: StateFlow<RegisterUiState>
        get() = _uiState

    init {
        Log.e("Frank", "RegisterViewModel ------------> init")
    }

    fun sendAction(action: RegisterAction) {
        Log.e("Frank", "RegisterViewModel handleAction ${action.javaClass.name}")
        when (action) {
            is RegisterAction.OnRegister -> {
                register(action.userName)
            }
            is RegisterAction.OnNavigated -> {
                _uiState.value = RegisterUiState.Default
            }
        }
    }

    private fun register(userName: String) {
        viewModelScope.launch {
            _uiState.value = RegisterUiState.Loading
            delay(2000L)
            _uiState.value = RegisterUiState.RegisterSuccess(userName = userName)
        }
    }


}


sealed class RegisterUiState {
    object Default: RegisterUiState()
    object Loading: RegisterUiState()
    data class RegisterSuccess(val userName: String): RegisterUiState()
    data class RegisterError(val msg: String): RegisterUiState()
}

sealed class RegisterAction {
    data class OnRegister(val userName: String): RegisterAction()
    object OnNavigated: RegisterAction()
}