package com.mukiva.simpleclock.presentation

import com.mukiva.simpleclock.navigation.NavigationDestination

data class NavigationItem(
    val isSelected: Boolean,
    val destination: NavigationDestination
)

data class MainState(
    val navigationItems: List<NavigationItem>
) {
    val firstSelectedNavigationItem
        get() = navigationItems.firstOrNull { it.isSelected } ?: firstNavigationItem

    private val firstNavigationItem
        get() = navigationItems.first()
}