package com.mukiva.simpleclock.presentation

import com.mukiva.presentation.SingleStateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    initialState: MainState
) : SingleStateViewModel<MainState>(initialState) {


}