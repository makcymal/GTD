package com.themakcym.gtd.data.dao

import androidx.room.*
import com.themakcym.gtd.data.entity.TaskEnt
import java.util.UUID


@Dao
abstract class TaskDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    abstract suspend fun createTask(task: TaskEnt)

    @Query("SELECT * FROM tasks WHERE taskId = :taskId")
    abstract suspend fun retrieveTask(taskId: UUID): List<TaskEnt>

    @Update
    abstract suspend fun updateTask(task: TaskEnt)

    @Delete
    abstract suspend fun deleteTask(task: TaskEnt)

    @Query("SELECT * FROM tasks WHERE groupId = :groupId ORDER BY taskUpdated")
    abstract suspend fun selectTasksByGroup(groupId: UUID): List<TaskEnt>
}