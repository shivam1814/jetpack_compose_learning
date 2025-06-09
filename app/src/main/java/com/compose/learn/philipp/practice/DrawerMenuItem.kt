package com.compose.learn.philipp.practice

import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerMenuItem(
    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: ImageVector
)
