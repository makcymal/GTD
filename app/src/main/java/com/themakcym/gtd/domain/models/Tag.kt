package com.themakcym.gtd.domain.models


data class Tag(
    val tagId: Int = UNDEFINED_ID,
    var tagTitle: String,
) {
    companion object {
        const val UNDEFINED_ID = 0
    }

    fun isUndefined(): Boolean {
        return tagId == UNDEFINED_ID
    }
}