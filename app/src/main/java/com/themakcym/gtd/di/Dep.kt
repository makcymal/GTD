package com.themakcym.gtd.di

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.themakcym.gtd.data.Database
import com.themakcym.gtd.data.LocalRepository
import com.themakcym.gtd.domain.Repository


@SuppressLint("StaticFieldLeak")
object Dep {

    private lateinit var context: Context

    fun init(context: Context) {
        Dep.context = context
    }

    private val db: Database by lazy {
        Room.databaseBuilder(context, Database::class.java, "gtd.db").build()
    }

    val repo: Repository by lazy {
        LocalRepository(db)
    }
}