package com.mukiva.simpleclock.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.mukiva.alarm.R
import com.mukiva.alarm.ui.AlarmScreen
import com.mukiva.simpleclock.navigation.IconResource
import com.mukiva.simpleclock.navigation.NavigationDestination

object AlarmDestination : NavigationDestination {

    private const val ROUTE_STRING = "feature/alarm"

    override val title: @Composable () -> String = { stringResource(R.string.feature_alarm_title) }
    override val icon: IconResource =
        IconResource(
            vector = { ImageVector.vectorResource(R.drawable.ic_alarm) },
            description = { stringResource(R.string.feature_alarm_title) }
        )
    override val route: String = ROUTE_STRING

    override val screen: @Composable () -> Unit = { AlarmScreen() }

}