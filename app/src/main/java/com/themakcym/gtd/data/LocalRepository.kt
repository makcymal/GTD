package com.themakcym.gtd.data

import com.themakcym.gtd.domain.Repository
import com.themakcym.gtd.data.models.Group
import com.themakcym.gtd.data.models.Tag
import com.themakcym.gtd.data.models.Task

class LocalRepository(private val db: Database) : Repository {

    override suspend fun createTask(task: Task) {
        db.taskDao().addTask(task)
    }

    override suspend fun updateTask(task: Task) {
        db.taskDao().updateTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        db.taskDao().deleteTask(task)
    }

    override suspend fun selectTasksByGroup(groupId: Int): List<Task> {
        return db.taskDao().getTasksByGroup(groupId)
    }

    // Task >>>


    // <<< Group

    override suspend fun createGroup(group: Group) {
        db.groupDao().addGroup(group)
    }

    override suspend fun updateGroup(group: Group) {
        db.groupDao().updateGroup(group)
    }

    override suspend fun deleteGroup(group: Group) {
        db.groupDao().deleteGroup(group)
    }

    override suspend fun getGroupsList(): List<Group> {
        return db.groupDao().getGroupsList()
    }

    // Group >>>

    // <<< Tag

    override suspend fun createTag(tag: Tag) {
        db.tagDao().addTag(tag)
    }

    override suspend fun updateTag(tag: Tag) {
        db.tagDao().updateTag(tag)
    }

    override suspend fun deleteTag(tag: Tag) {
        db.tagDao().deleteTag(tag)
    }

    override suspend fun getTagsList(): List<Tag> {
        return db.tagDao().getTagList()
    }

    // Tag >>>
}