package com.mukiva.simpleclock.presentation

import com.mukiva.presentation.SingleStateViewModel
import com.mukiva.simpleclock.navigation.NavigationDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    initialState: MainState
) : SingleStateViewModel<MainState>(initialState) {

    fun navigate(destination: NavigationDestination) {
        modifyState {
            copy(
                navigationItems = navigationItems.map {
                    it.copy(
                        isSelected = it.destination === destination
                    )
                }
            )
        }
    }

}