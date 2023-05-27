package com.themakcym.gtd.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.themakcym.gtd.domain.models.Group


class ViewPagerAdapter(fragmentActivity: FragmentActivity, private val groups: List<Group>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return groups.count()
    }

    override fun createFragment(position: Int): Fragment {
        return TasksFragment(groups[position].groupId)
    }
}
