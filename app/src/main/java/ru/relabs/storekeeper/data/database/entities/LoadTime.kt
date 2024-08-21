package ru.relabs.storekeeper.data.database.entities



data class LoadTime(
    val time: String, // Время загрузки
    val status: TimeStatus // Статус (вовремя, просрочено, не наступило)
)
