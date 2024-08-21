package ru.relabs.storekeeper.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.relabs.storekeeper.data.database.entities.Publication

@Composable
fun PublicationList(publications: List<Publication>) {
    LazyColumn {
        items(publications) { publication ->
            PublicationItem(publication)
        }
    }
}

@Composable
fun PublicationItem(publication: Publication) {
    Card(elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Информация о названии издания
            Text(text = publication.name, color = if (publication.isDataValid()) Color.Black else Color.Red)

            // Информация о тираже
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Тираж", modifier = Modifier.weight(1f))
                Text(text = publication.referenceQuantity.toString(), modifier = Modifier.weight(1f))
            }

            // Информация о пачках
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Количество пачек", modifier = Modifier.weight(1f))
                TextField(
                    value = publication.currentPacks.toString(),
                    onValueChange = { newValue ->
                        publication.currentPacks = newValue.toIntOrNull() ?: publication.currentPacks
                        // Обновление состояния Publication в случае необходимости
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            // Информация об остатке
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Остаток", modifier = Modifier.weight(1f))
                TextField(
                    value = publication.currentRemainder.toString(),
                    onValueChange = { newValue ->
                        publication.currentRemainder = newValue.toIntOrNull() ?: publication.currentRemainder
                        // Обновление состояния Publication в случае необходимости
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            // Кнопка "Ок"
            Button(onClick = {
                // Сохранение изменений в Publication
                // Передача данных в Сириус
            }) {
                Text("Ок")
            }
        }
    }
}

