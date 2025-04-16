package com.compose.learn.chezzycode.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.navigation.compose.composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.compose.learn.chezzycode.main.ui.theme.LearnTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            PreviewFunction()
//            Recomposable()
//            Theme()
//            ListComposable()
//            Counter()
//            LaunchEffectComposable()
//            CoroutineScopeComposable()
//            App()

//            Counters()
//            Loader()
//            Derived()

            NavApp()

        }
    }
}


@Composable
fun NavApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "registration",
        route = "root"
    ) {
        composable(route = "registration") {
            RegistrationScreen {
                navController.navigate("main/${it}")
            }
        }
        composable(route = "login") {
            LoginScreen()
        }
        composable(route = "main/{email}", arguments = listOf(
            navArgument("email") {
                type = NavType.StringType
            }
        )) {
            val email = it.arguments!!.getString("email")
            MainScreen(email!!)
        }
    }
}


//navigation
@Composable
fun RegistrationScreen(onClick: (email: String) -> Unit) {
    Text(
        text = "Registration Screen",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.clickable {
            onClick("shiavm@gmail.com")
        })
}

@Composable
fun LoginScreen() {
    Text(text = "Login Screen", style = MaterialTheme.typography.bodyMedium)
}

@Composable
fun MainScreen(email: String) {
    Text(text = "Main Screen - $email", style = MaterialTheme.typography.bodyMedium)
}


//produceState and derivedStateOf
@SuppressLint("UnrememberedMutableState")
@Composable
fun Derived() {
    val tableOf = remember { mutableStateOf(5) }
    val index = produceState(initialValue = 1) {
        repeat(9) {
            delay(1000)
            value += 1
        }
    }

    val message = derivedStateOf {
        "${tableOf.value} * ${index.value} = ${tableOf.value * index.value}"
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        Text(text = message.value, style = MaterialTheme.typography.headlineLarge)
    }
}


@Composable
fun Counters() {
    val state = produceState(0) {
        for (i in 1..10) {
            delay(1000)
            value += 1
        }
    }

    Text(
        text = state.value.toString(),
        style = MaterialTheme.typography.headlineLarge
    )
}

@Composable
fun Loader() {
    val degree = produceState(0) {
        while (true) {
            delay(20)
            value = (value + 15) % 360
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f),
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(degree.value.toFloat())
                )
                Text(text = "Loading")
            }
        }
    )
}


//Disposable Effect
/*@Composable
fun App() {
    *//*var state = remember { mutableStateOf(false) }

    DisposableEffect(key1 = state.value) {
        Log.d("code", "Disposable effect started")
        onDispose {
            Log.d("code", "Clean up code")
        }
    }

    Button(onClick = { state.value = !state.value }) {
        Text(text = "Change State")
    }*//*

//    MediaComposable()
    KeyboardComposable()
    TextField(value = "", onValueChange = {})

}

@Composable
fun KeyboardComposable() {
    val view = LocalView.current
    DisposableEffect(key1 = Unit) {
        val listner = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("code", isKeyboardVisible.toString())
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listner)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listner)
        }
    }
}

@Composable
fun MediaComposable() {
    val context = LocalContext.current
    var state = remember { mutableStateOf(false) }
    DisposableEffect(state.value) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.glass)
        mediaPlayer.start()
        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }

    Button(onClick = { state.value = !state.value }) {
        Text(text = "restart music")
    }
}*/


//rememberUpdateState

/*fun a() {
    Log.d("code", "I am A")
}

fun b() {
    Log.d("code", "I am B")
}

@Composable
fun App() {
    var state = remember { mutableStateOf(::a) }
    Button(onClick = { state.value = ::b }) {
        Text(text = "Click to change state")
    }
    LandingScreen(state.value)
}

@Composable
fun LandingScreen(onClick: () -> Unit) {
    val currentTimeout by rememberUpdatedState(onClick)
    LaunchedEffect(true) {
        delay(5000)
        currentTimeout()
    }
}


@Composable
fun CounterApp() {
    var counter = remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        counter.value = 10
    }
    CounterNew(counter.value)
}

@Composable
fun CounterNew(value: Int) {
    val state = rememberUpdatedState(value)
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d("code", state.value.toString())
    }
    Text(text = value.toString())
}*/


// remember coroutine scope
@Composable
fun LaunchEffectComposable() {
    val counter = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        Log.d("launchEffect", "started...")
        try {
            for (i in 1..10) {
                counter.value++
                delay(1000)
            }
        } catch (e: Exception) {
            Log.d("launchEffect", "exception : ${e.message.toString()}")
        }
    }

    var text = "counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "counter stopped"
    }
    Text(text = text)

}

@Composable
fun CoroutineScopeComposable() {
    val counter = remember { mutableStateOf(0) }
    //agr kisi event ke andr sideeffect handle krna hai to hum rememberCoroutineScope ka use krte hai
    //event like onClick
    var scope = rememberCoroutineScope()

    var text = "counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
    }

    Column {
        Text(text = text)
        Button(onClick = {
            scope.launch {
                Log.d("launchEffect", "started...")
                try {
                    for (i in 1..10) {
                        counter.value++
                        delay(1000)
                    }
                } catch (e: Exception) {
                    Log.d("launchEffect", "exception : ${e.message.toString()}")
                }
            }
        }) {
            Text(text = "start")
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
