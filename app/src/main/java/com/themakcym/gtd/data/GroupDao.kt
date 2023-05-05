package com.themakcym.gtd.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query


@Dao
abstract class GroupDao {

    @Insert
    abstract fun addGroup(group: Group)

    @Delete
    abstract fun deleteGroup(group: Group)

    @Update
    abstract fun updateGroup(group: Group)

    @Query("SELECT * from Group")
    abstract fun getGroupsList(): List<Group>
}