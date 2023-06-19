package com.themakcym.gtd.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.themakcym.gtd.databinding.ActivityMainBinding
import com.themakcym.gtd.presentation.viewmodels.MainViewModel
import com.themakcym.gtd.presentation.adapters.ViewPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var vpAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        viewModel.groups.observe(this) {
            binding.groupsTL.removeAllTabs()
            for (group in it) {
                binding.groupsTL.addTab(binding.groupsTL.newTab())
            }

            vpAdapter = ViewPagerAdapter(this, it)
            binding.groupsVP.adapter = vpAdapter

            TabLayoutMediator(binding.groupsTL, binding.groupsVP) { tab, idx ->
                tab.text = it[idx].groupTitle
            }.attach()
        }
//        viewModel.initialize()
        viewModel.getGroups()


        viewModel.new_group.observe(this) {
            viewModel.createGroup(it)
        }
        binding.newGroupBtn.setOnClickListener {
            NewGroupSheet().show(supportFragmentManager, "newGroupSheet")
        }


        viewModel.new_task.observe(this) {
            vpAdapter.getFragment(binding.groupsVP.currentItem).viewModel
                .createTask(it.first, it.second)
        }
        binding.newTaskFab.setOnClickListener {
            NewTaskSheet().show(supportFragmentManager, "newTaskSheet")
        }
    }
}
