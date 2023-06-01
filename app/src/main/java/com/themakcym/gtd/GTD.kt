package com.themakcym.gtd

import android.app.Application
import com.themakcym.gtd.di.Dep

class GTD: Application() {

    override fun onCreate() {
        super.onCreate()
        Dep.init(this)
    }
}