package com.themakcym.gtd.data.dao

import androidx.room.*
import com.themakcym.gtd.data.entity.GroupEnt


@Dao
abstract class GroupDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    abstract suspend fun insertGroup(group: GroupEnt)

    @Update
    abstract suspend fun updateGroup(group: GroupEnt)

    @Delete
    abstract suspend fun deleteGroup(group: GroupEnt)

    @Query("SELECT * FROM groups")
    abstract suspend fun selectGroups(): List<GroupEnt>

    @Query("DELETE FROM groups")
    abstract suspend fun dropGroups()
}