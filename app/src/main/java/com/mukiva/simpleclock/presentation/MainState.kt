package com.mukiva.simpleclock.presentation

import androidx.compose.ui.graphics.painter.Painter

interface IconResource {
    val painter: Painter
    val description: String
}

interface NavigationDestination {
    val isSelected: Boolean
    val title: String
    val icon: IconResource
    val route: String
}

data class MainState(
    val navigationItems: List<NavigationDestination>
)