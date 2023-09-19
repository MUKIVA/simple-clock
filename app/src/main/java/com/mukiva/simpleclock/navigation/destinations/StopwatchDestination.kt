package com.mukiva.simpleclock.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.mukiva.stopwatch.R
import com.mukiva.simpleclock.navigation.IconResource
import com.mukiva.simpleclock.navigation.NavigationDestination
import com.mukiva.stopwatch.ui.StopwatchScreen

object StopwatchDestination : NavigationDestination {

    private const val ROUTE_STRING = "feature/stopwatch"

    override val title: @Composable () -> String
        get() = { stringResource(R.string.feature_stopwatch_title) }
    override val icon: IconResource
        get() = IconResource(
            vector = { ImageVector.vectorResource(R.drawable.ic_stopwatch) },
            description = { stringResource(R.string.feature_stopwatch_title) }
        )
    override val route: String
        get() = ROUTE_STRING
    override val screen: @Composable () -> Unit
        get() = { StopwatchScreen() }
}