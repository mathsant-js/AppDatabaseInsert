package com.example.appdatabaseinsert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appdatabaseinsert.ui.theme.AppDatabaseInsertTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDatabaseInsertTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    var name by remember { mutableStateOf("") }
    var telephone by remember { mutableStateOf("") }
    Column(
        Modifier
            .background(Color(23,23,23))
    ) {
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            Text(
                text = "App DataBase",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.White
            )
        }
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(
                value = name,
                onValueChange = { name = it  },
                label = { Text("Nome") },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color(48,48,48),
                    unfocusedLabelColor = Color.White,
                    unfocusedContainerColor = Color(48,48,48),
                    unfocusedTextColor = Color.White,

                    focusedIndicatorColor = Color(0, 176, 21),
                    focusedLabelColor = Color.White,
                    focusedContainerColor = Color(48,48,48),
                    focusedTextColor = Color.White,

                    cursorColor = Color(0, 176, 21)

                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    // Serve para quando der o enter ele ir para o próximo campo
                    imeAction = ImeAction.Next
                )
            )
        }
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            TextField(
                value = telephone,
                onValueChange = { telephone = it  },
                label = { Text("Telefone") },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color(48,48,48),
                    unfocusedLabelColor = Color.White,
                    unfocusedContainerColor = Color(48,48,48),
                    unfocusedTextColor = Color.White,

                    focusedIndicatorColor = Color(0, 176, 21),
                    focusedLabelColor = Color.White,
                    focusedContainerColor = Color(48,48,48),
                    focusedTextColor = Color.White,

                    cursorColor = Color(0, 176, 21)

                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    // Serve para quando der o enter ele encerrar a digitação
                    imeAction = ImeAction.Done
                )
            )
        }
        Row(
            Modifier
                .padding(20.dp)
        ) {

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            Button(onClick = {
                // viewModel.upsertPessoa(pessoa) - > Database view
                name = ""
                telephone = ""

            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0, 176, 21), contentColor = Color.White)
            ) {
                Text("Cadastrar")
            }
        }
        Row(
            Modifier
                .padding(20.dp)
        ){

        }
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ){
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
            ) {
                Text(
                    text = "Nome",
                    color = Color(255,255,255)
                )
            }
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
            ) {
                Text(
                    text = "Telefone",
                    color = Color(255,255,255)
                )
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    AppDatabaseInsertTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            App()
        }
    }
}