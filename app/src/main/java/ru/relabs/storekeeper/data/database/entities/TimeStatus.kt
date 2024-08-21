package ru.relabs.storekeeper.data.database.entities

sealed class TimeStatus {
    object ON_TIME : TimeStatus() // Вовремя
    object OVERDUE : TimeStatus() // Просрочено
    object NOT_YET : TimeStatus() // Не наступило
}
