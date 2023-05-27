package com.themakcym.gtd.data.entity

import androidx.room.Entity
import java.util.UUID


@Entity(tableName = "tasks_to_tags", primaryKeys = ["taskId", "tagId"])
data class TaskTagRel (
    val taskId: UUID,
    val tagId: UUID,
)