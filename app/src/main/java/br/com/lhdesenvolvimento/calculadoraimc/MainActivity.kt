package br.com.lhdesenvolvimento.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.lhdesenvolvimento.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraIMCTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    ScreenSurface()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ScreenSurface() {
    var expanded: Boolean by remember { mutableStateOf(true) }

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Input("Digite sua altura...")
        Input("Digite seu peso...")
    }
}

@Composable
fun Input(placeholder: String) {
    var valueTextField: String by remember { mutableStateOf("") }
    TextField(
        value = valueTextField,
        onValueChange = { valueTextField = it },
        placeholder = {
            Text(text = placeholder)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculadoraIMCTheme {
        ScreenSurface()
    }
}