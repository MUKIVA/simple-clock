package com.mukiva.simpleclock.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.mukiva.timer.R
import com.mukiva.simpleclock.navigation.IconResource
import com.mukiva.simpleclock.navigation.NavigationDestination
import com.mukiva.timer.TimerScreen

object TimerDestination : NavigationDestination {

    private const val ROUTE_STRING = "feature/timer"

    override val title: @Composable () -> String
        get() = { stringResource(R.string.feature_timer_title) }
    override val icon: IconResource
        get() = IconResource(
            vector = { ImageVector.vectorResource(R.drawable.ic_timer) },
            description = { stringResource(R.string.feature_timer_title) }
        )
    override val route: String
        get() = ROUTE_STRING
    override val screen: @Composable () -> Unit
        get() = { TimerScreen() }
}