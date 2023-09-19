package com.mukiva.simpleclock.navigation

import androidx.compose.runtime.Composable

interface NavigationDestination {
    val title: @Composable () -> String
    val icon: IconResource
    val route: String
    val screen: @Composable () -> Unit
}