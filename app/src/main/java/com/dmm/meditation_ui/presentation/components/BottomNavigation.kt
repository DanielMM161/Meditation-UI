package com.dmm.meditation_ui.presentation.components
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.dmm.meditation_ui.presentation.navigation.AppScreens

@Composable
fun BottomBar(navController: NavHostController) {
  val screens = listOf(
    AppScreens.HomeScreen,
    AppScreens.MeditateScreen,
    AppScreens.SleepScreen
  )
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = navBackStackEntry?.destination
  
  BottomNavigation {
    screens.forEach { screen ->
      AddItem(
        screen = screen,
        currentDestination = currentDestination,
        navController = navController
      )
    }
  }
}

@Composable
fun RowScope.AddItem(
  screen: AppScreens,
  currentDestination: NavDestination?,
  navController: NavHostController
) {
  BottomNavigationItem(
    label = { Text( text = stringResource(id = screen.title))},
    icon = { Icon(painter = painterResource(id = screen.draw), contentDescription = stringResource(id = screen.title), modifier = Modifier.size(25.dp) )},
    selected = currentDestination?.hierarchy?.any {
      it.route == screen.route
    } == true,
    unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
    onClick = {
      navController.navigate(screen.route) {
        popUpTo(navController.graph.findStartDestination().id)
        launchSingleTop = true
      }
    }
  )
}

@Composable
fun BottomMenu(
  item: List<BottomItem>,
  modifier: Modifier = Modifier,
  activeHighlightColor: Color,
  activeTextColor: Color,
  inactiveTextColor: Color
) {
  Row(
    horizontalArrangement = Arrangement.SpaceAround,
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
      .fillMaxWidth()
      .background(Color.White)
      .padding(15.dp)
  ) {
    item.forEachIndexed { i, bottomItem ->
      BottomContent(
        item = bottomItem,
        activeHighlightColor = activeHighlightColor,
        activeTextColor = activeTextColor,
        inactiveTextColor = inactiveTextColor,
        modifier = modifier
      ) {

      }
    }
  }

}

@Composable
fun BottomContent(
  item: BottomItem,
  isSelected: Boolean = false,
  activeHighlightColor: Color,
  activeTextColor: Color,
  inactiveTextColor: Color,
  modifier: Modifier,
  onClick: () -> Unit
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.clickable {
      onClick
    }
  ) {
    Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier
        .clip(RoundedCornerShape(10.dp))
        .background(if (isSelected) activeHighlightColor else Color.Transparent)
        .padding(10.dp)
    ) {
      Icon(
        painter = painterResource(id = item.draw_id), 
        contentDescription = stringResource(id = item.string_id),
        tint = if(isSelected) activeTextColor else inactiveTextColor,
        modifier = Modifier.size(20.dp)
      )
      Text(
        text = stringResource(id = item.string_id),
        color = if(isSelected) activeTextColor else inactiveTextColor
      )
    }
  }
}

data class BottomItem(
  @StringRes val string_id: Int,
  @DrawableRes val draw_id: Int
)