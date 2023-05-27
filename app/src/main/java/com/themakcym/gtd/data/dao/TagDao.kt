package com.themakcym.gtd.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query
import com.themakcym.gtd.data.models.Tag


@Dao
abstract class TagDao {

    @Insert
    abstract fun addTag(tag: Tag)

    @Delete
    abstract fun deleteTag(tag: Tag)

    @Update
    abstract fun updateTag(tag: Tag)

    @Query("SELECT * from tags")
    abstract fun getTagList(): List<Tag>

}