package com.themakcym.gtd.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.themakcym.gtd.databinding.ActivityMainBinding


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
                val tab = binding.groupsTL.newTab().setText(group.groupTitle)
                binding.groupsTL.addTab(tab)
            }

            vpAdapter = ViewPagerAdapter(this, it)
            binding.groupsVP.adapter = vpAdapter

            TabLayoutMediator(binding.groupsTL, binding.groupsVP) { tab, idx ->
                tab.text = it[idx].groupTitle
            }.attach()

            val tab = binding.groupsTL.newTab().setText("+")
            binding.groupsTL.addTab(tab)
        }

        viewModel.selectGroups()
        viewModel.selectTags()
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
}