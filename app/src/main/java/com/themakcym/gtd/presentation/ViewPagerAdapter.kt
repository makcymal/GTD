package com.themakcym.gtd.presentation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.themakcym.gtd.domain.models.Task


class ViewPagerAdapter(fragmentActivity: MainActivity, private val tasks: List<Task>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return tasks.count()
    }

    override fun createFragment(position: Int): Fragment {
        return GroupFragment(tasks[position].taskId)
    }
}
