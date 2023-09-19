package com.mukiva.navigation

interface NavigationDestination {
    val isSelected: Boolean
    val title: String
    val icon: IconResource
    val route: String
}