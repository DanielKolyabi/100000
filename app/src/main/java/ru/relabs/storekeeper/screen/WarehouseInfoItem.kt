package ru.relabs.storekeeper.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WarehouseInfoItem(
    label: String,
    value: String,
    onEdit: (String) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = label, modifier = Modifier.weight(1f))
        Text(
            text = value,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    // Показать всплывающее окошко для редактирования
                    /*showEditDialog(
                        initialValue = value,
                        onConfirm = { newValue ->
                            onEdit(newValue)
                        }
                    )*/
                }
        )
    }
}