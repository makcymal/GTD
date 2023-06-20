package com.themakcym.gtd.data.dao

import androidx.room.*
import com.themakcym.gtd.data.entity.GroupEnt
import java.util.UUID


@Dao
abstract class GroupDao {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    abstract suspend fun createGroup(group: GroupEnt)

    @Query("SELECT * FROM groups WHERE groupId = :groupId")
    abstract suspend fun retrieveGroup(groupId: UUID): List<GroupEnt>

    @Update
    abstract suspend fun updateGroup(group: GroupEnt)

    @Delete
    abstract suspend fun deleteGroup(group: GroupEnt)

    @Query("SELECT * FROM groups")
    abstract suspend fun selectGroups(): List<GroupEnt>
}