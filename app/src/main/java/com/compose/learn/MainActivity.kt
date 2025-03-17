package com.compose.learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text("shivam")
        }
    }
}

/*
@Composable
fun setText(name:String = "shivam"){
    Text("hello $name")
}

@Preview(showBackground = true, name = "text 1")
@Composable
fun PreviewFuntion(){
    setText("shivam mandalia")
}
*/


@Preview(showBackground = true, widthDp = 300, heightDp = 400)
@Composable
fun PreviewFunction() {
    /*Text(
        text = "Hello World",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Red,
        fontSize = 36.sp,
        textAlign = TextAlign.Right
    )*/
    /*Image(
        painter = painterResource(R.drawable.apple),
        contentDescription = "dummy Image"
    )*/
    /*Button(
        onClick = {}, colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.Black
        ),
        enabled = true
    ) {
        Text(text = "click")
        Image(
            painter = painterResource(R.drawable.apple),
            contentDescription = "dummy Image"
        )
    }*/
}
