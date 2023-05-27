package com.themakcym.gtd.data.models

import java.util.UUID
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "groups")
data class Group (
    @PrimaryKey
    val groupId: UUID = UUID.randomUUID(),
    var groupTitle: String,
)
