package com.example.loginuygulama

import android.graphics.Paint.Align
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginuygulama.ui.theme.LoginUygulamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUygulamaTheme {
                // A surface container using the 'background' color from the theme
                Surface( color = MaterialTheme.colorScheme.background) {
                    Sayfa()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sayfa() {
    Surface(color = MaterialTheme.colorScheme.primary){

        val tfKullaniciAdi = remember { mutableStateOf("") }
        val tfSifre = remember { mutableStateOf("") }

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo" )
            TextField(
                value = tfKullaniciAdi.value,
                onValueChange = {tfKullaniciAdi.value = it},
                label = { Text(text = "Kullanici Adi")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White, //background color
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Red //secim yaptigimiz zaman belirtecin rengi
                )
            )
            TextField(
                value = tfSifre.value,
                onValueChange = {tfSifre.value = it},
                label = { Text(text = "Sifre")},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )

            Button(
                onClick = { Log.e("Button", "Giris Yapildi") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White //yazi rengi
                ),
                modifier = Modifier.size(250.dp, 50.dp)
            ) {
                Text(text = "Giris Yap")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginUygulamaTheme {
        Sayfa()
    }
}