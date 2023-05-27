package com.themakcym.gtd.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity
data class TaskEnt (
    var taskTitle: String,
    var groupId: UUID,
    @PrimaryKey
    val taskId: UUID,
    var taskDesc: String,
    var isCompleted: Boolean,
    var taskUpdated: String
)