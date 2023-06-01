package com.themakcym.gtd.domain

import java.util.UUID
import com.themakcym.gtd.domain.models.*


interface Repository {
    suspend fun createGroup(group: Group)
    suspend fun updateGroup(group: Group)
    suspend fun deleteGroup(group: Group)
    suspend fun getGroups(): List<Group>
    suspend fun dropGroups()

    suspend fun createTag(tag: Tag)
    suspend fun updateTag(tag: Tag)
    suspend fun deleteTag(tag: Tag)
    suspend fun getTags(): List<Tag>
    suspend fun dropTags()

    suspend fun createTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun selectTasksByGroup(groupId: UUID): List<Task>
    suspend fun getTasks(): List<Task>
    suspend fun dropTasks()

    suspend fun tagTask(taskId: UUID, tagId: UUID)
    suspend fun untagTask(taskId: UUID, tagId: UUID)
    suspend fun dropTaskTagRels()

    suspend fun createSubtask(subtask: Subtask)
    suspend fun updateSubtask(subtask: Subtask)
    suspend fun selectSubtasks(taskId: UUID): List<Subtask>

    suspend fun dropAll()
}
