package com.themakcym.gtd.data.dao

import androidx.room.*
import com.themakcym.gtd.data.entity.TaskTagRel
import java.util.UUID


@Dao
abstract class TaskTagDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    abstract suspend fun insertTaskTagRel(taskTagRel: TaskTagRel)

    @Delete
    abstract suspend fun deleteTaskTagRel(taskTagRel: TaskTagRel)

    @Query("SELECT tagId FROM tasks_to_tags WHERE taskId = :taskId")
    abstract suspend fun selectTagsByTask(taskId: UUID): List<UUID>

    @Query("DELETE FROM tasks_to_tags")
    abstract suspend fun dropTaskTagRels()
}
