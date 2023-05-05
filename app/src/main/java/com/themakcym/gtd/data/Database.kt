package com.themakcym.gtd.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Task::class, Group::class, Tag::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    abstract fun groupDao() : GroupDao

    abstract fun tagDao() : TagDao
}