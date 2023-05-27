package com.themakcym.gtd.data.dao

import androidx.room.*
import java.util.UUID


@Dao
abstract class TaskTagDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    abstract fun insertTaskTagRel(taskId: UUID, tagId: UUID)

    @Delete
    abstract fun deleteTaskTagRel(taskId: UUID, tagId: UUID)

    @Query("SELECT tagId FROM tasks_to_tags WHERE taskId = :taskId")
    abstract fun selectTagsByTask(taskId: UUID): List<UUID>
}