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

class RenameTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task, taskTitle: String) {
        if (taskTitle.isBlank()) {
            return
        }
        task.taskTitle = taskTitle.trim().replace('\n', ' ', false)
        task.taskUpdated = LocalDateTime.now()
        repo.updateTask(task)
    }
}

class DescribeTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task, taskDesc: String) {
        task.taskDesc = taskDesc.trim()
        task.taskUpdated = LocalDateTime.now()
        repo.updateTask(task)
    }
}

class MoveTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task, groupId: UUID) {
        task.groupId = groupId
        repo.updateTask(task)
    }
}

class CheckCompletionTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task) {
        task.isCompleted = !task.isCompleted
        task.taskUpdated = LocalDateTime.now()
        repo.updateTask(task)
    }
}

class TagTaskUC(private val repo: Repository) {
    suspend fun execute(taskId: UUID, tagId: UUID) {
        repo.tagTask(taskId, tagId)
    }
}

class UntagTaskUC(private val repo: Repository) {
    suspend fun execute(taskId: UUID, tagId: UUID) {
        repo.untagTask(taskId, tagId)
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

class GetTasksUC(private val repo: Repository) {
    suspend fun execute(): List<Task> {
        return repo.getTasks()
    }
}

class DropTasksUC(private val repo: Repository) {
    suspend fun execute() {
        repo.dropTasks()
    }
}

class CreateSubtaskUC(private val repo: Repository) {
    suspend fun execute(subtask: Subtask) {
        subtask.subtaskDetails = subtask.subtaskDetails.trim()
        repo.createSubtask(subtask)
    }
}

class CheckCompletionSubtaskUC(private val repo: Repository) {
    suspend fun execute(subtask: Subtask) {
        subtask.isCompleted = !subtask.isCompleted
        repo.updateSubtask(subtask)
    }
}

class SelectSubtasksUC(private val repo: Repository) {
    suspend fun execute(taskId: UUID): List<Subtask> {
        return repo.selectSubtasks(taskId)
    }
}

class DropAllUC(private val repo: Repository) {
    suspend fun execute() {
        repo.dropAll()
    }
}