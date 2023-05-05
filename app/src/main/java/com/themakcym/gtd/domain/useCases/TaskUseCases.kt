package com.themakcym.gtd.domain.useCases

import com.themakcym.gtd.data.Task
import com.themakcym.gtd.domain.Repository
import java.util.Date


class AddTaskUC(private val repository: Repository) {
    fun execute(task: Task) {
        repository.createTask(task)
    }
}

class RetrieveTaskUC(private val repository: Repository) {
    fun execute(taskId: Int) : Task {
        return repository.retrieveTask(taskId)
    }
}

class RenameTaskUC(private val repository: Repository) {
    fun execute(task: Task, taskTitle: String) {
        task.taskTitle = taskTitle
        task.taskUpdated = Date()
        repository.updateTask(task)
    }
}

class DescribeTaskUC(private val repository: Repository) {
    fun execute(task: Task, taskDescription: String) {
        task.taskTitle = taskDescription
        task.taskUpdated = Date()
        repository.updateTask(task)
    }
}

class MoveTaskUC(private val repository: Repository) {
    fun execute(task: Task, groupId: Int) {
        task.taskGroup = groupId
        repository.updateTask(task)
    }
}

class CompleteTaskUC(private val repository: Repository) {
    fun execute(task: Task) {
        assert(!task.isCompleted)
        task.isCompleted = true
        task.taskUpdated = Date()
        repository.updateTask(task)
    }
}

class IncompleteTaskUC(private val repository: Repository) {
    fun execute(task: Task) {
        assert(task.isCompleted)
        task.isCompleted = false
        task.taskUpdated = Date()
        repository.updateTask(task)
    }
}

class TagTaskUC(private val repository: Repository) {
    fun execute(task: Task, tagId: Int) {
        assert(task.taskTags.contains(tagId))
        task.taskTags += tagId
        repository.updateTask(task)
    }
}

class UntagTaskUC(private val repository: Repository) {
    fun execute(task: Task, tagId: Int) {
        assert(!task.taskTags.contains(tagId))
        task.taskTags -= tagId
        repository.updateTask(task)
    }
}

class DeleteTaskUC(private val repository: Repository) {
    fun execute(task: Task) {
        repository.deleteTask(task)
    }
}

class SelectTasksByGroup(private val repository: Repository) {
    fun execute(groupId: Int) : List<Task> {
        return repository.selectTasksByGroup(groupId)
    }
}