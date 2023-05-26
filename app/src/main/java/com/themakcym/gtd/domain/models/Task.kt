package com.themakcym.gtd.domain.models

import java.util.Date


data class Task(
    val taskId: Int = UNDEFINED_ID,
    var taskTitle: String,
    var taskDescription: String = "",
    var isCompleted: Boolean = false,
    var taskUpdated: Date,
    var taskGroup: Int,
    val taskTags: MutableList<Int> = mutableListOf(),
) {
    companion object {
        const val UNDEFINED_ID = 0
    }

    fun isUndefined(): Boolean {
        return taskId == UNDEFINED_ID
    }
}