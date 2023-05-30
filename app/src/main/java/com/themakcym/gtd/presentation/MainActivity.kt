package com.themakcym.gtd.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                binding.groupsTL.addTab(binding.groupsTL.newTab())
            }

            vpAdapter = ViewPagerAdapter(this, viewModel.tasks)
            binding.groupsVP.adapter = vpAdapter

            TabLayoutMediator(binding.groupsTL, binding.groupsVP) { tab, idx ->
                tab.text = it[idx].groupTitle
            }.attach()
        }
        viewModel.initialize()
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