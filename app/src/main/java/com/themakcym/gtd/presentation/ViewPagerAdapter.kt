package com.themakcym.gtd.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.themakcym.gtd.data.models.Task


class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val tasks: List<Task>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return tasks.count()
    }

    override fun createFragment(position: Int): Fragment {
        return TasksFragment(tasks[position].groupId)
    }
}
