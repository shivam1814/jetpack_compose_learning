package com.compose.learn.chezzycode.stateObject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class StateObjectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            NotificationScreen()
        }
    }
}