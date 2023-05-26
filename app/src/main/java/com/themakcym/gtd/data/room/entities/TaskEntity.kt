package com.themakcym.gtd.data.room.entities

import java.util.Date
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tasks")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    val taskId: Int,
    var taskTitle: String,
    var taskDescription: String,
    var isCompleted: Boolean,
    var taskUpdated: Date,
    var taskGroup: Int,
    val taskTags: MutableList<Int>,
)