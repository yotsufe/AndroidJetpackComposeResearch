package com.yotsufe.androidjetpackcomposeresearch

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yotsufe.androidjetpackcomposeresearch.app1.App1
import com.yotsufe.androidjetpackcomposeresearch.app1.Message
import com.yotsufe.androidjetpackcomposeresearch.app2.App2Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                    composable(route = "main") {
                        Greeting("Android", onClickButton = { navController.navigate("app1") })
                    }
                    composable(route = "app1") {
                        App1(
                            msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!"),
                            onClickButton = { navController.navigateUp() }
                        )
                    }
                }
                Button(
                    onClick = {
                        startActivity(App2Activity.createIntent(this@MainActivity))
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("App 2")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onClickButton: ()->Unit = {}) {
    val typography = MaterialTheme.typography
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Spacer(Modifier.height(16.dp))

        Text(text = "Hello $name!",
            style = typography.h6)

        Spacer(Modifier.height(8.dp))

        Text(text = "App Menu",
            style = typography.body2)

        Spacer(Modifier.height(8.dp))

        Button(onClick = onClickButton) {
            Text(text = "App 1")
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    Greeting("Android")
}
