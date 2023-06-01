package com.themakcym.gtd.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.themakcym.gtd.domain.models.*


class ViewPagerAdapter(fragmentActivity: FragmentActivity, private var groups: List<Group>) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments = arrayOfNulls<TasksFragment>(groups.count())

    override fun getItemCount(): Int {
        return groups.count()
    }

    override fun createFragment(pos: Int): Fragment {
        fragments[pos] = TasksFragment(groups[pos].groupId)
        return fragments[pos]!!
    }

    fun getFragment(position: Int): TasksFragment {
        if (fragments[position] == null) {
            fragments[position] = TasksFragment(groups[position].groupId)
        }
        return fragments[position]!!
    }
}
