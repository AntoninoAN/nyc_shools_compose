package com.example.nycschoolsnomerge_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nycschoolsnomerge_compose.ui.theme.NYCSchoolsNoMerge_ComposeTheme
import com.example.nycschoolsnomerge_compose.view.SchoolsHome
import com.example.nycschoolsnomerge_compose.viewmodel.SchoolViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainThemeApp {
                val viewModel: SchoolViewModel by viewModels()

                SchoolsHome(schoolViewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainThemeApp(content: @Composable () -> Unit) {
    NYCSchoolsNoMerge_ComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainThemeApp {
        Greeting("Android")
    }
}
