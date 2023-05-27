package com.themakcym.gtd.data.dao

import androidx.room.*
import com.themakcym.gtd.data.entity.TaskEnt
import java.util.UUID


@Dao
abstract class TaskDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    abstract fun insertTask(task: TaskEnt)

    @Update
    abstract fun updateTask(task: TaskEnt)

    @Delete
    abstract fun deleteTask(task: TaskEnt)

    @Query("SELECT * FROM tasks WHERE groupId = :groupId")
    abstract fun selectTasksByGroup(groupId: UUID): List<TaskEnt>
}