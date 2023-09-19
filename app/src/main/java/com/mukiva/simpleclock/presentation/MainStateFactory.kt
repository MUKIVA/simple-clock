package com.mukiva.simpleclock.presentation

import com.mukiva.simpleclock.navigation.destinations.AlarmDestination
import com.mukiva.simpleclock.navigation.destinations.ClockDestination
import com.mukiva.simpleclock.navigation.destinations.SleepingModeDestination
import com.mukiva.simpleclock.navigation.destinations.StopwatchDestination
import com.mukiva.simpleclock.navigation.destinations.TimerDestination

object MainStateFactory {
    fun create() = MainState(
        navigationItems = buildList {
            add(NavigationItem(isSelected = true, AlarmDestination))
            add(NavigationItem(isSelected = false, ClockDestination))
            add(NavigationItem(isSelected = false, StopwatchDestination))
            add(NavigationItem(isSelected = false, TimerDestination))
            add(NavigationItem(isSelected = false, SleepingModeDestination))
        }
    )
}