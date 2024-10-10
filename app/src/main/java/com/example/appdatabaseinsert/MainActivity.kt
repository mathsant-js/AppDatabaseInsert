package com.example.appdatabaseinsert

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.appdatabaseinsert.roomDB.Pessoa
import com.example.appdatabaseinsert.roomDB.PessoaDataBase
import com.example.appdatabaseinsert.ui.theme.AppDatabaseInsertTheme
import com.example.appdatabaseinsert.viewModel.PessoaViewModel
import com.example.appdatabaseinsert.viewModel.Repository

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            PessoaDataBase::class.java,
            name = "pessoa.db"
        ).build()
    }

    private val viewModel by viewModels<PessoaViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T: ViewModel> create(modelClass: Class<T>): T{
                    return PessoaViewModel(Repository(db)) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppDatabaseInsertTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App(viewModel, this)
                }
            }
        }
    }
}

@Composable
fun App(viewModel: PessoaViewModel, mainActivity: MainActivity) {
    var nome by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }

    val pessoa = Pessoa(
        nome,
        telefone
    )
    var pessoaList by remember { mutableStateOf(listOf<Pessoa>()) }
    viewModel.getPessoa().observe(mainActivity){
        pessoaList = it

    }
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
                value = nome,
                onValueChange = { nome = it  },
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
                value = telefone,
                onValueChange = { telefone = it  },
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
                viewModel.upsertPessoa(pessoa)
                nome = ""
                telefone = ""
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
                    fontWeight = FontWeight.Bold,
                    color = Color(255,255,255)
                )
            }
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
            ) {
                Text(
                    text = "Telefone",
                    fontWeight = FontWeight.Bold,
                    color = Color(255,255,255)
                )
            }
        }
        Divider()
        LazyColumn {
            items(pessoaList) { pessoa ->
                Row (
                    Modifier
                        .fillMaxWidth(),
                    Arrangement.Center
                ) {
                    Column (
                        Modifier
                            .fillMaxWidth(0.5f),
                        Arrangement.Center
                    ) {
                        Text(text = "${pessoa.nome}")
                    }
                    Column (
                        Modifier
                            .fillMaxWidth(0.5f),
                        Arrangement.Center
                    ) {
                        Text(text = "${pessoa.telefone}")
                    }
                }
                Divider()
            }
        }
    }
}