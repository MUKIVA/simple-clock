package com.mukiva.simpleclock.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class IconResource(
    val vector: @Composable () -> ImageVector,
    val description: @Composable () -> String
)