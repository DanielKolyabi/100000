package ru.relabs.storekeeper.data.database.entities


data class UnloadTime(
    val time: String, // Время выгрузки
    val status: TimeStatus // Статус (вовремя, просрочено, не наступило)
)
