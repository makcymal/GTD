package com.themakcym.gtd.domain.usecases

import com.themakcym.gtd.data.models.Group
import java.util.UUID
import java.util.Date
import com.themakcym.gtd.data.models.Task
import com.themakcym.gtd.domain.Repository


class AddTaskUC(private val repository: Repository) {
    suspend fun execute(task: Task) {
        repository.createTask(task)
    }
}

class RenameTaskUC(private val repository: Repository) {
    suspend fun execute(task: Task, taskTitle: String) {
        task.taskTitle = taskTitle
        task.taskUpdated = Date()
        repository.updateTask(task)
    }
}

class DescribeTaskUC(private val repository: Repository) {
    suspend fun execute(task: Task, taskDescription: String) {
        task.taskTitle = taskDescription
        task.taskUpdated = Date()
        repository.updateTask(task)
    }
}

class MoveTaskUC(private val repository: Repository) {
    suspend fun execute(task: Task, group: Group) {
        task.groupId = group
        repository.updateTask(task)
    }
}

class CompleteTaskUC(private val repository: Repository) {
    suspend fun execute(task: Task) {
        assert(!task.isCompleted)
        task.isCompleted = true
        task.taskUpdated = Date()
        repository.updateTask(task)
    }
}

class IncompleteTaskUC(private val repository: Repository) {
    suspend fun execute(task: Task) {
        assert(task.isCompleted)
        task.isCompleted = false
        task.taskUpdated = Date()
        repository.updateTask(task)
    }
}

class TagTaskUC(private val repository: Repository) {
    suspend fun execute(task: Task, tagId: UUID) {
        assert(task.tagsIds.contains(tagId))
        task.tagsIds += tagId
        repository.updateTask(task)
    }
}

class UntagTaskUC(private val repository: Repository) {
    suspend fun execute(task: Task, tagId: UUID) {
        assert(!task.tagsIds.contains(tagId))
        task.tagsIds -= tagId
        repository.updateTask(task)
    }
}

class DeleteTaskUC(private val repository: Repository) {
    suspend fun execute(task: Task) {
        repository.deleteTask(task)
    }
}

class GetTasksByGroupUC(private val repository: Repository) {
    suspend fun execute(groupId: UUID) : List<Task> {
        return repository.selectTasksByGroup(groupId)
    }
}