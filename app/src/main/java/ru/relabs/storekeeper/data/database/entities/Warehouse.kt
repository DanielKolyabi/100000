package ru.relabs.storekeeper.data.database.entities


data class Warehouse(
    val id: Int, // ИД склада
    val name: String, // Название склада
    val address: String, // Адрес склада
    val receiver: Receiver? = null, // Информация о приемщике (ФИО, телефон)
    val publications: List<Publication> = emptyList(), // Список изданий
    val loadTime: LoadTime? = null, // Время загрузки
    val unloadTime: UnloadTime? = null, // Время выгрузки
    val isExpanded: Boolean = false // Состояние развертывания склада)
)
