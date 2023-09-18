package com.mukiva.simpleclock.presentation

interface NavigationDestination

data class MainState(
    val navigationItems: List<NavigationDestination>
) {
    companion object {
        fun default() = MainState(
            navigationItems = emptyList()
        )
    }
}