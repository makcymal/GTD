package com.themakcym.gtd.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
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


        viewModel.notifier.observe(this) {
            binding.groupsTL.removeAllTabs()
            for (group in viewModel.groups) {
                binding.groupsTL.addTab(binding.groupsTL.newTab())
            }

            vpAdapter = ViewPagerAdapter(this, viewModel.groups)
            binding.groupsVP.adapter = vpAdapter

            TabLayoutMediator(binding.groupsTL, binding.groupsVP) { tab, idx ->
                tab.text = viewModel.groups[idx].groupTitle
            }.attach()
        }
        viewModel.selectGroups()


        viewModel.updatedGroupPos.observe(this) {
            vpAdapter.notifyItemChanged(it)
        }


        viewModel.newGroup.observe(this) {
            viewModel.createGroup(it)
        }
        binding.newGroupBtn.setOnClickListener {
            NewGroupSheet().show(supportFragmentManager, "newGroupSheet")
        }


        binding.editGroupBtn.setOnClickListener {
            if (vpAdapter.itemCount > 0) {
                val groupDialog =
                    GroupDialog(
                        vpAdapter.groupAt(binding.groupsVP.currentItem),
                        viewModel,
                        binding.groupsVP.currentItem
                    )
                groupDialog.show(supportFragmentManager, "groupDialog")
            } else {
                val snack = Snackbar.make(binding.root, "First you should create group", 1200)
                snack.show()
            }
        }

        viewModel.newTask.observe(this) {
            vpAdapter.getFragment(binding.groupsVP.currentItem).viewModel
                .createTask(it.first, it.second)
        }
        binding.newTaskFab.setOnClickListener {
            if (vpAdapter.itemCount > 0) {
                NewTaskSheet().show(supportFragmentManager, "newTaskSheet")
            } else {
                val snack = Snackbar.make(binding.root, "First you should create group", 1200)
                snack.show()
            }
        }
    }
}
