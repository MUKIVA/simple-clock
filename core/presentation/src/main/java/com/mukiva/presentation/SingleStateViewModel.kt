package com.mukiva.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class SingleStateViewModel<TState>(
    initialState: TState
) : ViewModel() {
    val state: StateFlow<TState> by lazy { mState }

    private val mState = MutableStateFlow(initialState)

    private fun modifyState(newState: TState) {
        viewModelScope.launch {
            mState.emit(newState)
        }
    }

    fun modifyState(initializer: TState.() -> TState) {
        modifyState(mState.value.initializer())
    }

}