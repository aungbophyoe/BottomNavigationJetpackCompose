package com.aungbophyoe.space.bottomnavigationjetpackcompose

import androidx.annotation.DrawableRes

sealed class BottomNavItem(
    val title : String,
    val route : String,
    @DrawableRes val icon : Int,
    val badgeCount : Int = 0
) {
    object Chats : BottomNavItem("Chats","chats",R.drawable.ic_chat,12)
    object Calls : BottomNavItem("Calls","calls",R.drawable.ic_call,0)
    object People : BottomNavItem("People","people",R.drawable.ic_people,0)
    object Stories : BottomNavItem("Stories","stories",R.drawable.ic_stories,0)
}