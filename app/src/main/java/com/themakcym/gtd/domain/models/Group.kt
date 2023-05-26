package com.themakcym.gtd.domain.models


data class Group(
    val groupId: Int = UNDEFINED_ID,
    var groupTitle: String,
) {
    companion object {
        const val UNDEFINED_ID: Int = 0
    }

    fun isUndefined(): Boolean {
        return groupId == UNDEFINED_ID
    }
}