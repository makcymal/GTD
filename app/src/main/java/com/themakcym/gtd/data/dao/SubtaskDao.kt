package com.themakcym.gtd.data.dao

import androidx.room.*
import com.themakcym.gtd.data.entity.SubtaskEnt
import java.util.UUID


@Dao
abstract class SubtaskDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    abstract suspend fun insertSubtask(subtask: SubtaskEnt)

    @Update
    abstract suspend fun updateSubtask(subtask: SubtaskEnt)

    @Query("SELECT * FROM subtasks WHERE taskId = :taskId")
    abstract suspend fun selectSubtasks(taskId: UUID): List<SubtaskEnt>
}