package com.themakcym.gtd.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.themakcym.gtd.data.dao.*
import com.themakcym.gtd.data.entity.*


@Database(entities = [GroupEnt::class, TagEnt::class, TaskEnt::class, SubtaskEnt::class, TaskTagRel::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun groupDao() : GroupDao

    abstract fun tagDao() : TagDao

    abstract fun taskDao() : TaskDao

    abstract fun subtaskDao() : SubtaskDao

    abstract fun taskTagDao() : TaskTagDao
}
