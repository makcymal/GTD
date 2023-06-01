package com.themakcym.gtd.data.entity

import androidx.room.Entity
import java.util.UUID


@Entity(tableName = "subtasks", primaryKeys = ["taskId", "subtaskPrior"])
data class SubtaskEnt (
    val subtaskDetails: String,
    val taskId: UUID,
    val subtaskPrior: Int,
    val isCompleted: Boolean,
)
