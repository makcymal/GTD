package com.themakcym.gtd.data.dao

import androidx.room.*
import com.themakcym.gtd.data.entity.GroupEnt


@Dao
abstract class GroupDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    abstract fun insertGroup(group: GroupEnt)

    @Update
    abstract fun updateGroup(group: GroupEnt)

    @Delete
    abstract fun deleteGroup(group: GroupEnt)

    @Query("SELECT * FROM groups")
    abstract fun selectGroups(): List<GroupEnt>
}