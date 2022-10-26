package com.dmm.meditation_ui.presentation.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.dmm.meditation_ui.R
import com.dmm.meditation_ui.presentation.Utils.HOME_SCREEN
import com.dmm.meditation_ui.presentation.Utils.MEDITATE_SCREEN
import com.dmm.meditation_ui.presentation.Utils.SLEEP_SCREEN

sealed class AppScreens(
  val route: String,
  @StringRes val title: Int,
  @DrawableRes val draw: Int
  ) {
  object HomeScreen : AppScreens(
    route = HOME_SCREEN,
    title = R.string.bottom_home,
    draw = R.drawable.ic_home
  )

  object MeditateScreen : AppScreens(
    route = MEDITATE_SCREEN,
    title = R.string.bottom_meditate,
    draw = R.drawable.ic_bubble
  )

  object SleepScreen : AppScreens(
    route = SLEEP_SCREEN,
    title = R.string.bottom_sleep,
    draw = R.drawable.ic_moon
  )
}
