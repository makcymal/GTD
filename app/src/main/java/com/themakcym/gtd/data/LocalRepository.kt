package com.themakcym.gtd.data

import com.themakcym.gtd.domain.Repository
import com.themakcym.gtd.domain.models.*
import java.util.*


class LocalRepository(private val db: Database) : Repository {

    private val mapper = Mapper()


    override suspend fun createGroup(group: Group) {
        db.groupDao().createGroup(mapper.groupIntoEnt(group))
    }

    override suspend fun retrieveGroup(groupId: UUID): Group {
        return mapper.groupFromEnt(db.groupDao().retrieveGroup(groupId)[0])
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


    override suspend fun createTask(task: Task) {
        db.taskDao().createTask(mapper.taskIntoEnt(task))
    }

    override suspend fun retrieveTask(taskId: UUID): Task {
        return mapper.taskFromEnt(db.taskDao().retrieveTask(taskId)[0])
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

    override suspend fun selectStarredTasksByGroup(groupId: UUID): List<Task> {
        val tasks = mutableListOf<Task>()
        for (taskEnt in db.taskDao().selectStarredTasksByGroup(groupId)) {
            tasks += mapper.taskFromEnt(taskEnt)
        }
        return tasks
    }


    override suspend fun createSubtask(subtask: Subtask) {
        db.subtaskDao().createSubtask(mapper.subtaskIntoEnt(subtask))
    }

    override suspend fun deleteSubtasksByTask(taskId: UUID) {
        db.subtaskDao().deleteSubtasksByTask(taskId)
    }

    override suspend fun selectSubtasksByTask(taskId: UUID): List<Subtask> {
        val subtasks = mutableListOf<Subtask>()
        for (subtaskEnt in db.subtaskDao().selectSubtasksByTask(taskId)) {
            subtasks += mapper.subtaskFromEnt(subtaskEnt)
        }
        return subtasks
    }
}
