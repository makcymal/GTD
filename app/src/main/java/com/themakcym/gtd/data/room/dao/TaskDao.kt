package com.themakcym.gtd.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query
import com.themakcym.gtd.domain.models.Task

@Dao
abstract class TaskDao {

    @Insert
    abstract fun addTask(task: Task)

    @Delete
    abstract fun deleteTask(task: Task)

    @Update
    abstract fun updateTask(task: Task)

    @Query("SELECT * from Task WHERE groupId = :groupId")
    abstract fun getTasksByGroup(groupId: Int): List<Task>
}