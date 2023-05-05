package com.themakcym.gtd.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query

@Dao
abstract class TaskDao {

    @Insert
    abstract fun addTask(task: Task)

    @Delete
    abstract fun deleteTask(task: Task)

    @Update
    abstract fun updateTask(task: Task)

    @Query("SELECT * from Task WHERE groupId = :groupId")
    abstract fun getTaskById(taskId: Int): Task

    @Query("SELECT * from Task JOIN Group USING('groupId') WHERE groupId = :groupId")
    abstract fun getTasksByGroup(groupId: Int): List<Task>
}