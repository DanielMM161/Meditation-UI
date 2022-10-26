package com.dmm.meditation_ui.presentation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.dmm.meditation_ui.presentation.components.BottomBar
import com.dmm.meditation_ui.presentation.navigation.AppNavigation

@Composable
fun MainScreen() {
  val navController = rememberNavController()
  Scaffold(
    topBar = {},
    bottomBar = { BottomBar(navController = navController) }
  ) {
    AppNavigation(navController = navController)
  }
}