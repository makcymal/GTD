package com.themakcym.gtd.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.themakcym.gtd.R
import com.themakcym.gtd.data.Database
import com.themakcym.gtd.data.Task


class MainActivity : AppCompatActivity() {

//    lateinit var db: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db = Room.databaseBuilder(this, Database::class.java, "gtd.db").build()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            db.taskDao().addTask(Task())
        }
    }

//    private fun initViewPager() {
//        val vp = findViewById<ViewPager2>(R.id.groupVP)
//        val adapter = ViewPagerAdapter(this)
//
//        adapter.submitList(categories)
//        vp.adapter = adapter
//
//        val tb = findViewById<TabLayout>(R.id.groupsTL)
//
//        TabLayoutMediator(tb, vp) { tab, pos ->
//            tab.text = categories[pos]
//        }.attach()
//
//        val tab = tb.newTab().setText("+")
//        tb.addTab(tab)
//    }

    fun completionAction(view: View) {

    }

    fun deleteAction(view: View) {

    }

    fun renameAction(view: View) {

    }
}