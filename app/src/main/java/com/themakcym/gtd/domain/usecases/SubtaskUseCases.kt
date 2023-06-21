package com.themakcym.gtd.domain.usecases

import java.util.UUID
import com.themakcym.gtd.domain.models.Subtask
import com.themakcym.gtd.domain.Repository


class CreateSubtaskUC(private val repo: Repository) {
    suspend fun execute(subtask: Subtask) {
        subtask.subtaskDetails = subtask.subtaskDetails.trim()
        repo.createSubtask(subtask)
    }
}

class RetrieveSubtaskUC(private val repo: Repository) {
    suspend fun execute(taskId: UUID, subtaskId: Int): Subtask {
        return repo.retrieveSubtask(taskId, subtaskId)
    }
}

class UpdateSubtaskUC(private val repo: Repository) {
    suspend fun execute(subtask: Subtask) {
        if (subtask.subtaskDetails.isBlank()) {
            return
        }
        subtask.subtaskDetails = subtask.subtaskDetails.trim()
        repo.updateSubtask(subtask)
    }
}

class DeleteSubtaskUC(private val repo: Repository) {
    suspend fun execute(subtask: Subtask) {
        repo.deleteSubtask(subtask)
    }
}

class DeleteSubtasksByTaskUC(private val repo: Repository) {
    suspend fun execute(taskId: UUID) {
        repo.deleteSubtasksByTask(taskId)
    }
}

class SelectSubtasksByTaskUC(private val repo: Repository) {
    suspend fun execute(taskId: UUID): List<Subtask> {
        return repo.selectSubtasksByTask(taskId)
    }
}

class CheckSubtaskUC(private val repo: Repository) {
    suspend fun execute(subtask: Subtask) {
        subtask.isCompleted = !subtask.isCompleted
        repo.updateSubtask(subtask)
    }
}