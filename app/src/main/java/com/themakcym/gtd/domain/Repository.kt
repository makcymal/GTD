package com.themakcym.gtd.domain

import java.util.UUID
import com.themakcym.gtd.domain.models.*


interface Repository  {
    suspend fun createGroup(group: Group)
    suspend fun updateGroup(group: Group)
    suspend fun deleteGroup(group: Group)
    suspend fun selectGroups() : List<Group>

    suspend fun insertTag(tag: Tag)
    suspend fun updateTag(tag: Tag)
    suspend fun deleteTag(tag: Tag)
    suspend fun selectTags() : List<Tag>

    suspend fun createTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun selectTasksByGroup(groupId: UUID) : List<Task>

    suspend fun tagTask(taskId: UUID, tagId: UUID)
    suspend fun untagTask(taskId: UUID, tagId: UUID)
}
