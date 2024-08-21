package ru.relabs.storekeeper.screen
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import ru.relabs.storekeeper.data.database.entities.WarehouseData


@Composable
fun WarehouseAddressScreen(warehouseData: WarehouseData) {
    Column {
        // Область заголовка (фиксация сверху)
        Text(text = "Адрес Склада", style = MaterialTheme.typography.headlineLarge)

        // Список изданий
        PublicationList(publications = warehouseData.publications)

        // Информация об автомобиле
        CarInfo(carNumber = warehouseData.carNumber)

        // Контакты
        Contacts(contacts = listOf(
            warehouseData.manager,
            warehouseData.brigadier,
            warehouseData.distributor
        ))

        // Область примечания (фиксация снизу)
        Text(text = "Примечания", style = MaterialTheme.typography.bodySmall)
    }
}



