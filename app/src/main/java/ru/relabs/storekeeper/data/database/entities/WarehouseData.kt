package ru.relabs.storekeeper.data.database.entities

data class WarehouseData(
    val id: Int,
    val publications: List<Publication>,
    val carNumber: String? = null,
    val manager: Contact,
    val brigadier: Contact,
    val distributor: Contact
)
