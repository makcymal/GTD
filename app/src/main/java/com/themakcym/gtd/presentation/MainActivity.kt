package com.themakcym.gtd.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.themakcym.gtd.databinding.ActivityMainBinding
import com.themakcym.gtd.presentation.viewmodels.MainViewModel
import com.themakcym.gtd.presentation.adapters.ViewPagerAdapter
import com.themakcym.gtd.presentation.viewmodels.NewTaskViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var newTaskViewModel: NewTaskViewModel
    private lateinit var vpAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        newTaskViewModel = ViewModelProvider(this)[NewTaskViewModel::class.java]

        mainViewModel.groups.observe(this) {
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
        mainViewModel.getGroups()

        newTaskViewModel.title_desc.observe(this) {
            vpAdapter.getFragment(binding.groupsVP.currentItem).viewModel
                .createTask(it.first, it.second)
        }

        binding.newTaskFAB.setOnClickListener {
            NewTaskSheet().show(supportFragmentManager, "newTaskSheet")
        }
    }
}
