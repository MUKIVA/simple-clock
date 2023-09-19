package com.mukiva.simpleclock.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mukiva.simpleclock.navigation.NavigationDestination
import com.mukiva.simpleclock.presentation.MainViewModel
import com.mukiva.simpleclock.presentation.NavigationItem

@Composable
fun MainScreen(vm: MainViewModel = viewModel()) {

    val navController = rememberNavController()
    val state = vm.state.collectAsState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                state.value.navigationItems.forEach {
                    AddItem(
                        item = it,
                        onClick = vm::navigate)
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = state.value.firstSelectedNavigationItem.destination.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            state.value.navigationItems.forEach {
                addRoute(it.destination)
            }
        }
    }
}

fun NavGraphBuilder.addRoute(item: NavigationDestination) {
    composable(item.route) { item.screen() }
}

@Composable
fun RowScope.AddItem(
    item: NavigationItem,
    onClick: (NavigationDestination) -> Unit
) {
    NavigationBarItem(
        selected = item.isSelected,
        onClick = {
            onClick(item.destination)
                  },
        icon = { Icon(
            imageVector = item.destination.icon.vector(),
            contentDescription = item.destination.icon.description()
        ) },
        label = { Text(text = item.destination.title()) }
    )
}