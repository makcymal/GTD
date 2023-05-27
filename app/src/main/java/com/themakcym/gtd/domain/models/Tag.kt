package com.themakcym.gtd.domain.models

import java.util.UUID


data class Tag (
    var tagTitle: String,
    val tagId: UUID = UNDEFINED_ID,
) {
    companion object {
        val UNDEFINED_ID: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")
    }

    fun isUndefined(): Boolean {
        return tagId == UNDEFINED_ID
    }
}
