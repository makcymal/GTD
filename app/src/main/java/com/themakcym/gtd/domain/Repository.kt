package com.themakcym.gtd.domain

import java.util.UUID
import com.themakcym.gtd.domain.models.*


interface Repository {
    suspend fun createGroup(group: Group)
    suspend fun retrieveGroup(groupId: UUID): Group
    suspend fun updateGroup(group: Group)
    suspend fun deleteGroup(group: Group)
    suspend fun selectGroups(): List<Group>

    suspend fun createTask(task: Task)
    suspend fun retrieveTask(taskId: UUID): Task
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun selectTasksByGroup(groupId: UUID): List<Task>

    suspend fun createSubtask(subtask: Subtask)
    suspend fun retrieveSubtask(taskId: UUID, subtaskId: Int): Subtask
    suspend fun updateSubtask(subtask: Subtask)
    suspend fun deleteSubtask(subtask: Subtask)
    suspend fun selectSubtasksByTask(taskId: UUID): List<Subtask>
}
