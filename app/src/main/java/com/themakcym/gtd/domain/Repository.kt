package com.themakcym.gtd.domain

import com.themakcym.gtd.data.Group
import com.themakcym.gtd.data.Tag
import com.themakcym.gtd.data.Task

interface Repository  {
    fun createTask(task: Task)
    fun retrieveTask(taskId: Int) : Task
    fun updateTask(task: Task)
    fun deleteTask(task: Task)
    fun selectTasksByGroup(groupId: Int) : List<Task>

    fun createTag(tag: Tag)
    fun updateTag(tag: Tag)
    fun deleteTag(tag: Tag)
    fun getTagsList() : List<Tag>

    fun createGroup(group: Group)
    fun updateGroup(group: Group)
    fun deleteGroup(group: Group)
    fun getGroupsList() : List<Group>
}