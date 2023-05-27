package com.themakcym.gtd.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.themakcym.gtd.data.dao.GroupDao
import com.themakcym.gtd.data.dao.TagDao
import com.themakcym.gtd.data.dao.TaskDao
import com.themakcym.gtd.data.models.Group
import com.themakcym.gtd.data.models.Tag
import com.themakcym.gtd.data.models.Task


@Database(entities = [Task::class, Group::class, Tag::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    abstract fun groupDao() : GroupDao

    abstract fun tagDao() : TagDao
}