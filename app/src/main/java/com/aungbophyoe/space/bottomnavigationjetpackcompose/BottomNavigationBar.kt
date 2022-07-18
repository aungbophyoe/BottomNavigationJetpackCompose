package com.aungbophyoe.space.bottomnavigationjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavController
){
    val navItems = listOf(BottomNavItem.Chats,BottomNavItem.Calls,BottomNavItem.People,BottomNavItem.Stories)
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        navItems.forEach { bottomNavItem ->
            BottomNavigationItem(
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if(bottomNavItem.badgeCount > 0){
                            BadgedBox(badge = {
                                Badge{
                                    Text(text = bottomNavItem.badgeCount.toString(), fontSize = 10.sp)
                                }
                            }
                            ) {
                                Icon(painter = painterResource(id = bottomNavItem.icon) , contentDescription = bottomNavItem.title)
                            }
                        }else{
                            Icon(painter = painterResource(id = bottomNavItem.icon) , contentDescription = bottomNavItem.title)
                        }
                    }
                       },
                label = { Text(text = bottomNavItem.title)} ,
                selectedContentColor = colorResource(id = R.color.c_color),
                unselectedContentColor = colorResource(id = R.color.silver),
                selected = currentRoute == bottomNavItem.route,
                onClick = {
                    navController.navigate(bottomNavItem.route)
                })
        }
    }

}