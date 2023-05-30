package com.themakcym.gtd.data

import com.themakcym.gtd.data.entity.TaskTagRel
import com.themakcym.gtd.domain.Repository
import com.themakcym.gtd.domain.models.*
import java.util.*


class LocalRepository(private val db: Database) : Repository {

    private val mapper = Mapper()

    // <<< Group

    override suspend fun createGroup(group: Group) {
        db.groupDao().insertGroup(mapper.groupIntoEnt(group))
    }

    override suspend fun updateGroup(group: Group) {
        db.groupDao().updateGroup(mapper.groupIntoEnt(group))
    }

    override suspend fun deleteGroup(group: Group) {
        db.groupDao().deleteGroup(mapper.groupIntoEnt(group))
    }

    override suspend fun selectGroups(): List<Group> {
        val groups = mutableListOf<Group>()
        for (groupEnt in db.groupDao().selectGroups()) {
            groups += mapper.groupFromEnt(groupEnt)
        }
        return groups
    }

    override suspend fun dropGroups() {
        db.groupDao().dropGroups()
    }

    // Group >>>

    // <<< Tag

    override suspend fun insertTag(tag: Tag) {
        db.tagDao().insertTag(mapper.tagIntoEnt(tag))
    }

    override suspend fun updateTag(tag: Tag) {
        db.tagDao().updateTag(mapper.tagIntoEnt(tag))
    }

    override suspend fun deleteTag(tag: Tag) {
        db.tagDao().deleteTag(mapper.tagIntoEnt(tag))
    }

    override suspend fun selectTags(): List<Tag> {
        val tags = mutableListOf<Tag>()
        for (tagEnt in db.tagDao().selectTags()) {
            tags += mapper.tagFromEnt(tagEnt)
        }
        return tags
    }

    override suspend fun dropTags() {
        db.tagDao().dropTags()
    }

    // Tag >>>

    // <<< Task

    override suspend fun createTask(task: Task) {
        db.taskDao().insertTask(mapper.taskIntoEnt(task))
        for (taskTagRel in mapper.taskIntoRel(task)) {
            db.taskTagDao().insertTaskTagRel(TaskTagRel(taskTagRel.taskId, taskTagRel.tagId))
        }
    }

    override suspend fun updateTask(task: Task) {
        db.taskDao().updateTask(mapper.taskIntoEnt(task))
    }

    override suspend fun deleteTask(task: Task) {
        db.taskDao().deleteTask(mapper.taskIntoEnt(task))
    }

    override suspend fun selectTasksByGroup(groupId: UUID): List<Task> {
        val tasks = mutableListOf<Task>()
        for (taskEnt in db.taskDao().selectTasksByGroup(groupId)) {
            val tagsIds = db.taskTagDao().selectTagsByTask(taskEnt.taskId)
            tasks += mapper.taskFromEnt(taskEnt, tagsIds)
        }
        return tasks
    }

    override suspend fun getTasks() : List<Task> {
        val tasks = mutableListOf<Task>()
        for (taskEnt in db.taskDao().getTasks()) {
            val tagsIds = db.taskTagDao().selectTagsByTask(taskEnt.taskId)
            tasks += mapper.taskFromEnt(taskEnt, tagsIds)
        }
        return tasks
    }

    override suspend fun dropTasks() {
        db.taskDao().dropTasks()
    }

    override suspend fun tagTask(taskId: UUID, tagId: UUID) {
        db.taskTagDao().insertTaskTagRel(TaskTagRel(taskId, tagId))
    }

    override suspend fun untagTask(taskId: UUID, tagId: UUID) {
        db.taskTagDao().deleteTaskTagRel(TaskTagRel(taskId, tagId))
    }

    override suspend fun dropTaskTagRels() {
        db.taskTagDao().dropTaskTagRels()
    }

    override suspend fun dropAll() {
        dropGroups()
        dropTags()
        dropTasks()
        dropTaskTagRels()
    }

    // Task >>>
}