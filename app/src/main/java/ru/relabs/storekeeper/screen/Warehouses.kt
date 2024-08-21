package ru.relabs.storekeeper.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Button
import androidx.compose.material3.Card

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier


import androidx.compose.ui.unit.dp
import ru.relabs.storekeeper.data.database.entities.Warehouse


@Composable
fun WarehouseScreen(warehouses: List<Warehouse>, onWarehouseClick: (Int) -> Unit) {
    Column {
        warehouses.forEach { warehouse ->
            WarehouseItem(warehouse, onWarehouseClick)
        }
    }
}

@Composable
fun WarehouseItem(
    warehouse: Warehouse,
    onWarehouseClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                // Отправляем статус "Подтверждено"
                // ...
                onWarehouseClick(warehouse.id)
            }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = warehouse.name, style = MaterialTheme.typography.headlineLarge)
            if (warehouse.isExpanded) {
                // Отображает информацию о складе, если он развернут
                WarehouseDetails(warehouse)
            }
        }
    }
}

@Composable
fun WarehouseDetails(warehouse: Warehouse) {
    // ФИО приемщика
    WarehouseInfoItem(
        label = "ФИО приемщика",
        value = warehouse.receiver?.name ?: "",
        onEdit = { newName ->
            // Передаем новое ФИО в Сириус
            // ...
        }
    )

    // Номера телефонов
    warehouse.receiver?.phoneNumbers?.forEach { phoneNumber ->
        WarehouseInfoItem(
            label = "Телефон",
            value = phoneNumber,
            onEdit = { newPhoneNumber ->
                // Передаем новый номер телефона в Сириус
                // ...
            }
        )
    }

    // Кнопка добавления телефона
    if (warehouse.receiver?.phoneNumbers?.size ?: 0 < 3) {
        Button(onClick = {
            // Добавляем новое поле для ввода телефона
            // ...
        }) {
            Text("Добавить телефон")
        }
    }

    // Список изданий
    Column(modifier = Modifier.padding(8.dp)) {
        warehouse.publications.groupBy { it.date }.forEach { (date, publications) ->
            Text(text = date, style = MaterialTheme.typography.headlineLarge)
            publications.groupBy { it.flightNumber }.forEach { (flightNumber, publications) ->
                Button(
                    onClick = {
                        // Переход на экран 2
                        // ...
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Рейс $flightNumber")
                }
                publications.forEach { publication ->
                    Text(text = publication.title)
                }
            }
        }
    }

    // Время загрузки
    WarehouseInfoItem(
        label = "Время загрузки",
        value = warehouse.loadTime?.time ?: "",
        onEdit = { /* Обработка изменения времени загрузки */ }
    )

    // Время отгрузки
    WarehouseInfoItem(
        label = "Время отгрузки",
        value = warehouse.unloadTime?.time ?: "",
        onEdit = { /* Обработка изменения времени отгрузки */ }
    )
}