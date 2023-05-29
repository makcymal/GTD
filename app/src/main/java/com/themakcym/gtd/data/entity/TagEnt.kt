package com.themakcym.gtd.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "tags")
data class TagEnt(
    var tagTitle: String,
    @PrimaryKey
    val tagId: UUID
)