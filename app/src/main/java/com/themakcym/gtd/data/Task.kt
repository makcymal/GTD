package com.themakcym.gtd.data

import java.util.Date
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val taskId: Int = UNDEFINED_ID,
    var taskTitle: String = "New Task",
    var taskDescription: String = "",
    var isCompleted: Boolean = false,
    var taskUpdated: Date = Date(),
    var taskGroup: Int = DEFAULT_GROUP,
    val taskTags: MutableList<Int> = mutableListOf(),
) {
    companion object {
        const val UNDEFINED_ID = 0
        const val DEFAULT_GROUP = 1
    }
}