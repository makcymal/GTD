package com.themakcym.gtd.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.themakcym.gtd.databinding.TasksFragmentBinding
import java.util.UUID


class TasksFragment(private val groupId: UUID) : Fragment() {

    private lateinit var binding: TasksFragmentBinding
    private lateinit var viewModel: TasksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = TasksFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TasksViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tasksRecycler.adapter = TasksAdapter()
        binding.tasksRecycler.layoutManager = LinearLayoutManager(requireActivity())


    }
}