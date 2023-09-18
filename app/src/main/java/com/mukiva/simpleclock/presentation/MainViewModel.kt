package com.mukiva.simpleclock.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    initialState: MainState
) : ViewModel() {

    val state: StateFlow<MainState> by lazy { mState }

    private val mState = MutableStateFlow(initialState)

    fun modifyState(newState: MainState) {
        viewModelScope.launch {
            mState.emit(newState)
        }
    }

    fun modifyState(initializer: MainState.() -> MainState) {
        modifyState(mState.value.initializer())
    }

}