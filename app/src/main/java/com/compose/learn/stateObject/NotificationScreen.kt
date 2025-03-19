package com.compose.learn.stateObject

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, heightDp = 500, widthDp = 500)
@Composable
fun NotificationScreen() {
    var count = remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        NotificationCounter(count.value, { count.value++ })
        MessageBar(count.value)
    }
}

@Composable
fun MessageBar(count: Int) {
    Card(elevation = CardDefaults.cardElevation(8.dp)) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "",
                modifier = Modifier.padding(4.dp)
            )
            Text(text = "Mesasge so far - $count")

        }
    }
}

@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) {

    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "You have send $count notifications")
        Button(onClick = {
            increment()
            Log.d("notification", "Button clicked")
        }) {
            Text(text = "Send Notification")
        }
    }
}