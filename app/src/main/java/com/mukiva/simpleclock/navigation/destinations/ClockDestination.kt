package com.mukiva.simpleclock.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.mukiva.clock.R
import com.mukiva.clock.ui.ClockScreen
import com.mukiva.simpleclock.navigation.IconResource
import com.mukiva.simpleclock.navigation.NavigationDestination

object ClockDestination : NavigationDestination {

    private const val ROUTE_STRING = "feature/clock"

    override val title: @Composable () -> String =
        { stringResource(R.string.feature_clock_title) }
    override val icon: IconResource
        get() = IconResource(
            vector = { ImageVector.vectorResource(R.drawable.ic_clock) },
            description = { stringResource(R.string.feature_clock_title) }
        )
    override val route: String
        get() = ROUTE_STRING

    override val screen: @Composable () -> Unit = { ClockScreen() }
}