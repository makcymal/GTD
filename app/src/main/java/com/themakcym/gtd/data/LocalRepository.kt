package com.themakcym.gtd.data

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

    override suspend fun getGroups(): List<Group> {
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


    // <<< Task

    override suspend fun createTask(task: Task) {
        db.taskDao().insertTask(mapper.taskIntoEnt(task))
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
            tasks += mapper.taskFromEnt(taskEnt)
        }
        return tasks
    }

    override suspend fun getTasks(): List<Task> {
        val tasks = mutableListOf<Task>()
        for (taskEnt in db.taskDao().getTasks()) {
            tasks += mapper.taskFromEnt(taskEnt)
        }
        return tasks
    }

    override suspend fun dropTasks() {
        db.taskDao().dropTasks()
    }

    override suspend fun createSubtask(subtask: Subtask) {
        db.subtaskDao().insertSubtask(mapper.subtaskIntoEnt(subtask))
    }

    override suspend fun updateSubtask(subtask: Subtask) {
        db.subtaskDao().updateSubtask(mapper.subtaskIntoEnt(subtask))
    }

    override suspend fun selectSubtasks(taskId: UUID): List<Subtask> {
        val subtasks = mutableListOf<Subtask>()
        for (subtaskEnt in db.subtaskDao().selectSubtasks(taskId)) {
            subtasks += mapper.subtaskFromEnt(subtaskEnt)
        }
        return subtasks
    }

    override suspend fun dropAll() {
        dropGroups()
        dropTasks()
    }

    // Task >>>
}