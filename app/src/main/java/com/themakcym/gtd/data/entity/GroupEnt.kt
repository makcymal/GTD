package com.themakcym.gtd.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "groups")
data class GroupEnt (
    var groupTitle: String,
    @PrimaryKey
    val groupId: UUID,
)
