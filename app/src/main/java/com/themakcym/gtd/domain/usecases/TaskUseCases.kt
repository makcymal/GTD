package com.themakcym.gtd.domain.usecases

import java.util.UUID
import com.themakcym.gtd.domain.models.Task
import com.themakcym.gtd.domain.Repository
import com.themakcym.gtd.domain.models.Subtask
import java.time.LocalDateTime


class CreateTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task) {
        if (task.taskTitle.isBlank()) {
            return
        }
        task.taskTitle = task.taskTitle.trim().replace('\n', ' ', false)
        task.taskDesc = task.taskDesc.trim()
        repo.createTask(task)
    }
}

class RetrieveTaskUC(private val repo: Repository) {
    suspend fun execute(taskId: UUID): Task {
        return repo.retrieveTask(taskId)
    }
}

class UpdateTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task) {
        if (task.taskTitle.isBlank()) {
            return
        }
        task.taskTitle = task.taskTitle.trim().replace('\n', ' ', false)
        task.taskDesc = task.taskDesc.trim()
        task.taskUpdated = LocalDateTime.now()
        repo.updateTask(task)
    }
}

class DeleteTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task) {
        repo.deleteTask(task)
    }
}

class SelectTasksByGroupUC(private val repo: Repository) {
    suspend fun execute(groupId: UUID): List<Task> {
        return repo.selectTasksByGroup(groupId)
    }
}

class CheckTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task) {
        task.isCompleted = !task.isCompleted
        task.taskUpdated = LocalDateTime.now()
        repo.updateTask(task)
    }
}

class StarTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task) {
        task.isStarred = !task.isStarred
        repo.updateTask(task)
    }
}


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
