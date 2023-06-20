package com.themakcym.gtd.data.dao

import androidx.room.*
import com.themakcym.gtd.data.entity.SubtaskEnt
import java.util.UUID


@Dao
abstract class SubtaskDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    abstract suspend fun createSubtask(subtask: SubtaskEnt)

    @Query("SELECT * FROM subtasks WHERE taskId = :taskId AND subtaskId = :subtaskId")
    abstract suspend fun retrieveSubtask(taskId: UUID, subtaskId: Int): List<SubtaskEnt>

    @Update
    abstract suspend fun updateSubtask(subtask: SubtaskEnt)

    @Delete
    abstract suspend fun deleteSubtask(subtask: SubtaskEnt)

    @Query("SELECT * FROM subtasks WHERE taskId = :taskId")
    abstract suspend fun selectSubtasksByTask(taskId: UUID): List<SubtaskEnt>
}