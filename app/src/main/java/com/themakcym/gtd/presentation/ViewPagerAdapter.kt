package com.themakcym.gtd.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.models.Task


class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val tasks: MutableList<MutableLiveData<List<Task>>>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun createFragment(position: Int): Fragment {
        return TasksFragment(tasks[position])
    }
}
