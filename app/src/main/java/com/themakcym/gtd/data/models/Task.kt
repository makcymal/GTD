package com.themakcym.gtd.data.models

import java.util.UUID
import java.util.Date
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks")
data class Task (
    @PrimaryKey
    val taskId: UUID = UUID.randomUUID(),
    var taskTitle: String,
    var taskDescription: String = "",
    var isCompleted: Boolean = false,
    var taskUpdated: Date = Date(),
    var groupId: Group,
    val tagsIds: MutableList<UUID> = mutableListOf(),
)
