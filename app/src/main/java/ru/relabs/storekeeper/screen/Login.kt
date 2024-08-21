package ru.relabs.storekeeper.screen



import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
/*import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff*/
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*

import androidx.compose.ui.text.input.VisualTransformation
import ru.relabs.storekeeper.data.network.ApiClient


@Composable
fun LoginScreen(
    /*onLoginSuccess: () -> Unit,*/

) {
    val api: ApiClient
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    var rememberPassword by remember { mutableStateOf(true) }
    var loginError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Логотип или заголовок
        Text(
            text = "Курьер Экспедирование Менеджер",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Blue
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Текстовое поле "Логин"
        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Логин") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Текстовое поле "Пароль"
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Пароль") },
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            /*trailingIcon = {
               IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(
                        imageVector = if (showPassword) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = if (showPassword) "Скрыть пароль" else "Показать пароль"
                    )
                }
            },*/
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Чекбокс "Запомнить пароль"
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = rememberPassword,
                onCheckedChange = { rememberPassword = it }
            )
            Text("Запомнить логин")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка "Войти"
        Button(
            onClick = {
                // Отправка логина и пароля на сервер
                if (login.isNotBlank() && password.isNotBlank()) {
                    // Имитация запроса на авторизацию
                    if (login == "user" && password == "password") {
                        /*onLoginSuccess()*/
                    } else {
                        loginError = "Неверный логин или пароль"
                    }
                } else {
                    loginError = "Введите логин и пароль"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Войти")
        }

        // Отображение ошибки
        loginError?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = it, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Кнопка "Войти без подключения" (для оффлайн-режима)
        /*Button(
            onClick = {
                onOfflineLogin()
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = false // Включите, если нужна оффлайн-авторизация
        ) {
            Text("Войти без подключения")
        }*/
    }
}