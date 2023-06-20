package com.themakcym.gtd.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "tasks")
data class TaskEnt (
    val taskTitle: String,
    val groupId: UUID,
    @PrimaryKey
    val taskId: UUID,
    val taskDesc: String,
    val isCompleted: Boolean,
    val isStarred: Boolean,
    val taskUpdated: String
)
