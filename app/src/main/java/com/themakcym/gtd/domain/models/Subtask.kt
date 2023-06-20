package com.themakcym.gtd.domain.models

import java.util.UUID


data class Subtask (
    var subtaskDetails: String,
    val taskId: UUID,
    val subtaskId: Int,
    var isCompleted: Boolean = false,
)
