package com.themakcym.gtd.presentation.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.themakcym.gtd.domain.models.*
import com.themakcym.gtd.presentation.TasksFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val groups: List<Group>) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments = arrayOfNulls<TasksFragment>(groups.count())

    override fun getItemCount(): Int {
        return groups.count()
    }

    override fun createFragment(position: Int): Fragment {
        fragments[position] = TasksFragment(groups[position].groupId)
        return fragments[position]!!
    }

    fun getFragment(position: Int): TasksFragment {
        if (fragments[position] == null) {
            fragments[position] = TasksFragment(groups[position].groupId)
        }
        return fragments[position]!!
    }

    fun groupAt(position: Int): Group {
        return groups[position]
    }
}
