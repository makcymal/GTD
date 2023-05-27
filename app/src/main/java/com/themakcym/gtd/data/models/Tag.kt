package com.themakcym.gtd.data.models

import java.util.UUID
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tags")
data class Tag(
    @PrimaryKey
    val tagId: UUID = UUID.randomUUID(),
    var tagTitle: String,
)
