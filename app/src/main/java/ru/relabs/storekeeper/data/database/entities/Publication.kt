package ru.relabs.storekeeper.data.database.entities

data class Publication(
    val title: String, // Название издания
    val date: String, // Дата издания
    val flightNumber: String, // Номер рейса
    val id: Int,
    val name: String,
    val referenceQuantity: Int,
    val referencePacks: Int,
    val referenceRemainder: Int,
    var currentPacks: Int,
    var currentRemainder: Int,
    val carNumber: String? = null,
    val photos: List<Photo> = emptyList()
) {
    fun isDataValid(): Boolean {
        // Проверка корректности данных (Тираж, пачки, остаток)
        return true // Замените на необходимую логику проверки
    }
}
