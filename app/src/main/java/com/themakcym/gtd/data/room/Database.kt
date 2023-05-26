package com.themakcym.gtd.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.themakcym.gtd.data.room.dao.GroupDao
import com.themakcym.gtd.data.room.dao.TagDao
import com.themakcym.gtd.data.room.dao.TaskDao
import com.themakcym.gtd.data.room.entities.GroupEntity
import com.themakcym.gtd.data.room.entities.TagEntity
import com.themakcym.gtd.data.room.entities.TaskEntity
import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.models.Tag
import com.themakcym.gtd.domain.models.Task


@Database(entities = [TaskEntity::class, GroupEntity::class, TagEntity::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    abstract fun groupDao() : GroupDao

    abstract fun tagDao() : TagDao
}