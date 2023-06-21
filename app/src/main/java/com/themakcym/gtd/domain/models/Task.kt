package com.themakcym.gtd.domain.models

import java.util.UUID
import java.time.LocalDateTime


data class Task(
    var taskTitle: String,
    var groupId: UUID,
    val taskId: UUID = UNDEFINED_ID,
    var taskDesc: String = "",
    var isCompleted: Boolean = false,
    var isStarred: Boolean = false,
    var taskUpdated: LocalDateTime = LocalDateTime.now(),
    var subtaskId: Int = 0,
) {
    companion object {
        val UNDEFINED_ID: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")
    }

    fun isUndefined(): Boolean {
        return taskId == UNDEFINED_ID
    }

    fun nextSubtaskId(): Int {
        subtaskId++
        return subtaskId
    }
}
