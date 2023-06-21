package com.themakcym.gtd.domain.models

import java.util.UUID


data class Subtask (
    val taskId: UUID,
    val subtaskId: Int,
    var subtaskDetails: String = "",
    var isCompleted: Boolean = false,
)
