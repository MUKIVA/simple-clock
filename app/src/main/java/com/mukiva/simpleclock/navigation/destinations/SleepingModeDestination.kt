package com.mukiva.simpleclock.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.mukiva.simpleclock.navigation.IconResource
import com.mukiva.simpleclock.navigation.NavigationDestination
import com.mukiva.sleeping_mode.R
import com.mukiva.sleeping_mode.ui.SleepingModeScreen

object SleepingModeDestination : NavigationDestination {

    private const val ROUTE_STRING = "feature/sleeping-mode"

    override val title: @Composable () -> String = {
        stringResource(R.string.feature_sleeping_mode_title)
    }
    override val icon: IconResource
        get() = IconResource(
            vector = { ImageVector.vectorResource(R.drawable.ic_sleeping_mode) },
            description = { stringResource(id = R.string.feature_sleeping_mode_title) }
        )
    override val route: String
        get() = ROUTE_STRING

    override val screen: @Composable () -> Unit = { SleepingModeScreen() }

}