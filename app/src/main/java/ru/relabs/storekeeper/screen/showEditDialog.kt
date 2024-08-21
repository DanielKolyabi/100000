package ru.relabs.storekeeper.screen

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun showEditDialog(
    initialValue: String,
    onConfirm: (String) -> Unit
) {
    var text by remember { mutableStateOf(initialValue) }

    AlertDialog(
        onDismissRequest = { },
        title = { Text("Редактирование") },
        text = {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Новое значение") }
            )
        },
        confirmButton = {
            Button(onClick = { onConfirm(text) }) {
                Text("ОК")
            }
        }
    )
}