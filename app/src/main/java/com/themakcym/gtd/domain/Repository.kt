package com.themakcym.gtd.domain

import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.models.Tag
import com.themakcym.gtd.domain.models.Task

interface Repository  {
    suspend fun createTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(task: Task)
    suspend fun selectTasksByGroup(groupId: Int) : List<Task>

    suspend fun createTag(tag: Tag)
    suspend fun updateTag(tag: Tag)
    suspend fun deleteTag(tag: Tag)
    suspend fun getTagsList() : List<Tag>

    suspend fun createGroup(group: Group)
    suspend fun updateGroup(group: Group)
    suspend fun deleteGroup(group: Group)
    suspend fun getGroupsList() : List<Group>
}