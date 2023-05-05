package com.themakcym.gtd.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Group(
    @PrimaryKey(autoGenerate = true)
    val groupId: Int = UNDEFINED_ID,
    var groupTitle: String,
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}