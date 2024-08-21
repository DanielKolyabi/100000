package ru.relabs.storekeeper.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

import ru.relabs.storekeeper.data.database.entities.Contact


@Composable
fun Contacts(contacts: List<Contact>) {
    val context = LocalContext.current
    val phoneNumber = "1234567890"
    val intent = Intent(Intent.ACTION_DIAL)

    Column(modifier = Modifier.padding(16.dp)) {
        contacts.forEach { contact ->
            // Отображение контактной информации
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = contact.name, modifier = Modifier.weight(1f))
                Text(
                    text = contact.phone,
                    modifier = Modifier.weight(1f),
                    color = Color.Blue,
                    clickable = true,
                    onClick = {
                        // Вызов по телефону
                        intent.data = Uri.parse("tel:$phoneNumber")
                        context.startActivity(intent)

                    }
                )
            }
        }
    }
}










