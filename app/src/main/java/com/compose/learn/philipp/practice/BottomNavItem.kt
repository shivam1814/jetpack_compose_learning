package com.compose.learn.philipp.practice

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name:String,
    val route:String,
    val icon:ImageVector,
    val badgeCount:Int = 0
)
