package com.themakcym.gtd.domain.models

import java.util.UUID


data class Group (
    var groupTitle: String,
    val groupId: UUID = UNDEFINED_ID,
) {
    companion object {
        val UNDEFINED_ID: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")
    }

    fun isUndefined(): Boolean {
        return groupId == UNDEFINED_ID
    }
}
