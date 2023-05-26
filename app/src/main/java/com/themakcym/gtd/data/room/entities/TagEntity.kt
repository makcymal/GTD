package com.themakcym.gtd.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tags")
data class TagEntity(
    @PrimaryKey(autoGenerate = true)
    val tagId: Int,
    var tagTitle: String,
)