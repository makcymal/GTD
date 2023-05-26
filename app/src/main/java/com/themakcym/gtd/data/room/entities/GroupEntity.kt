package com.themakcym.gtd.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Groups")
data class GroupEntity (
    @PrimaryKey(autoGenerate = true)
    val groupId: Int,
    var groupTitle: String,
)