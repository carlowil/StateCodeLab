package com.example.basicstate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask : (WellnessTask, Boolean) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id } // По умолчанию, состояние каждого элемента соответствует его положению,
                // Чтобы не было проблем с удалением, и сохранением состояния, нужно привязать каждый элемент к id
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onClose = { onCloseTask(task) },
                onCheckedChange = { checked -> onCheckedTask(task, checked) }
            )
        }
    }
}