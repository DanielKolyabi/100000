package ru.relabs.storekeeper.data.database.entities

data class Receiver(
    val name: String, // ФИО приемщика
    val phoneNumbers: List<String> = emptyList() // Список телефонов
)
