package com.themakcym.gtd.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Tag(
    @PrimaryKey(autoGenerate = false)
    val tagId: Int = UNDEFINED_ID,
    var tagTitle: String,
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}