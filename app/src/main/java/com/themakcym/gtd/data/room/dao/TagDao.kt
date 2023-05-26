package com.themakcym.gtd.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query
import com.themakcym.gtd.domain.models.Tag


@Dao
abstract class TagDao {

    @Insert
    abstract fun addTag(tag: Tag)

    @Update
    abstract fun updateTag(tag: Tag)

    @Delete
    abstract fun deleteTag(tag: Tag)

    @Query("SELECT * from Tag")
    abstract fun getTagList(): List<Tag>

}