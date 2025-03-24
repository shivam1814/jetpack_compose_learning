package com.compose.learn.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.learn.main.ui.theme.LearnTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            PreviewFunction()
//            Recomposable()
//            Theme()
//            ListComposable()
            Counter()
        }
    }
}


//side effects in jetpack compose
@Composable
fun ListComposable() {
    val categoryState = remember { mutableStateOf(emptyList<String>()) }

    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchCategories()
    }

    LazyColumn {
        items(categoryState.value) { item ->
            Text(text = item)
        }
    }
}

fun fetchCategories(): List<String> {
    return listOf("one", "two", "three")
}

@Composable
fun Counter() {
    var count = remember { mutableStateOf(0) }
    var key = count.value % 3 == 0
    LaunchedEffect(key1 = key) {
        Log.d("Counter", "Current count : ${count.value}")
    }

    Button(onClick = { count.value++ }) {
        Text("increment count")
    }
}

//light and dark theme
@Composable
fun Theme() {
    var theme = remember { mutableStateOf(false) }
    LearnTheme(theme.value) {
        Column {
            Text(
                text = "shivam",
                style = MaterialTheme.typography.titleMedium
            )
            Button(onClick = {
                theme.value = !theme.value
            }) {
                Text(text = "Change Theme")
            }
        }

    }
}

@Composable
fun Recomposable() {
    val state = remember { mutableStateOf(0.0) }
    Log.d("TAGGED", "Initial composition")
    Button(
        onClick = {
            state.value = Math.random()
        }
    ) {
        Log.d("TAGGED", "Composition & Recomposition")
        Text(text = state.value.toString())
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
private fun PreviewFunction() {
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
    /*TextField(
        value = "Enter Value",
        onValueChange = {},
        label = { Text(text = "Enter message") },
        placeholder = { Text(text = "Please Enter message") }
    )*/

    /*Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
    }*/

    /*Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
    }*/

    /*Box (
        contentAlignment = Alignment.BottomEnd
    ){
        Image(painter = painterResource(R.drawable.apple), contentDescription = "demo")
        Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "demo")
    }*/

    /*Column {
        ListView(R.drawable.user,"shivam","software developer")
        ListView(R.drawable.user,"shivam","software developer")
        ListView(R.drawable.user,"shivam","software developer")
        ListView(R.drawable.user,"shivam","software developer")
    }*/

    /*Text(
        text = "hello", modifier = Modifier.clickable {}
            .background(Color.Blue)
            .size(200.dp)
            .border(4.dp,Color.Red)
            .clip(CircleShape)
            .background(Color.Yellow)

    )*/

}


@Composable
fun ListView(imageId: Int, name: String, occupation: String) {
    Row(
        Modifier.padding(10.dp)
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = "user image",
            Modifier.size(40.dp)
        )
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = occupation,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun TextInput() {
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
        },
        label = { Text(text = "Enter message") },
    )
}
