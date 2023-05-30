package com.themakcym.gtd.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query
import com.themakcym.gtd.data.entity.TagEnt


@Dao
abstract class TagDao {

    @Insert
    abstract suspend fun insertTag(tag: TagEnt)

    @Update
    abstract suspend fun updateTag(tag: TagEnt)

    @Delete
    abstract suspend fun deleteTag(tag: TagEnt)

    @Query("SELECT * FROM tags")
    abstract suspend fun selectTags(): List<TagEnt>

    @Query("DELETE FROM tags")
    abstract suspend fun dropTags()
}