package com.mukiva.simpleclock.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mukiva.simpleclock.presentation.MainViewModel
import com.mukiva.simpleclock.presentation.NavigationDestination

@Composable
fun MainScreen(vm: MainViewModel = viewModel()) {

    val navController = rememberNavController()
    val state = vm.state.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavigationBar {
            state.value.navigationItems.forEach {
                this.AddItem(item = it, navController = navController)
            }
        }
    }
}

@Composable
fun RowScope.AddItem(item: NavigationDestination, navController: NavHostController) {
    NavigationBarItem(
        selected = item.isSelected,
        onClick = { navController.navigate(item.route) },
        icon = { Icon(
            painter = item.icon.painter,
            contentDescription = item.icon.description
        ) },
        label = { Text(text = item.title) }
    )
}