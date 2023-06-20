package com.themakcym.gtd.data.entity

import androidx.room.Entity
import java.util.UUID


@Entity(tableName = "subtasks", primaryKeys = ["taskId", "subtaskId"])
data class SubtaskEnt (
    val subtaskDetails: String,
    val taskId: UUID,
    val subtaskId: Int,
    val isCompleted: Boolean,
)
