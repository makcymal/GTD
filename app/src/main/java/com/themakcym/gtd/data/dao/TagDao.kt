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
    abstract fun insertTag(tag: TagEnt)

    @Update
    abstract fun updateTag(tag: TagEnt)

    @Delete
    abstract fun deleteTag(tag: TagEnt)

    @Query("SELECT * FROM tags")
    abstract fun selectTags(): List<TagEnt>

}