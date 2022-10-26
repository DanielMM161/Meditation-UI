package com.dmm.meditation_ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dmm.meditation_ui.presentation.screens.HomeScreen
import com.dmm.meditation_ui.presentation.screens.MeditateScreen
import com.dmm.meditation_ui.presentation.screens.SleepScreen

@Composable
fun AppNavigation(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = AppScreens.HomeScreen.route
  ) {
    composable(route = AppScreens.HomeScreen.route) {
      HomeScreen()
    }
    composable(route = AppScreens.MeditateScreen.route) {
      MeditateScreen()
    }
    composable(route = AppScreens.SleepScreen.route) {
      SleepScreen()
    }
  }
}