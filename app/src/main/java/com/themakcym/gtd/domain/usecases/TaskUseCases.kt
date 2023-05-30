package com.themakcym.gtd.domain.usecases

import java.util.UUID
import com.themakcym.gtd.domain.models.Task
import com.themakcym.gtd.domain.Repository
import java.time.LocalDateTime


class CreateTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task) {
        repo.createTask(task)
    }
}

class RenameTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task, taskTitle: String) {
        task.taskTitle = taskTitle
        task.taskUpdated = LocalDateTime.now()
        repo.updateTask(task)
    }
}

class DescribeTaskUC(private val repo: Repository) {
    suspend fun execute(task: Task, taskDesc: String) {
        task.taskDesc = taskDesc
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
    suspend fun execute(groupId: UUID) : List<Task> {
        return repo.selectTasksByGroup(groupId)
    }
}

class GetTasksUC(private val repo: Repository) {
    suspend fun execute() : List<Task> {
        return repo.getTasks()
    }
}

class DropTasksUC(private val repo: Repository) {
    suspend fun execute() {
        repo.dropTasks()
    }
}

class DropAllUC(private val repo: Repository) {
    suspend fun execute() {
        repo.dropAll()
    }
}