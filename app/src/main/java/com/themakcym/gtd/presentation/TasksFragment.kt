package com.themakcym.gtd.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.themakcym.gtd.databinding.TasksFragmentBinding
import java.util.UUID


class TasksFragment(private val groupId: UUID) : Fragment() {

    private lateinit var binding: TasksFragmentBinding
    lateinit var viewModel: TasksViewModel
    private val rvAdapter = TasksAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = TasksFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TasksViewModel::class.java]
        viewModel.groupId = groupId
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tasksRecycler.adapter = rvAdapter
        binding.tasksRecycler.layoutManager = LinearLayoutManager(requireActivity())

        viewModel.tasks.observe(requireActivity()) {
            rvAdapter.submitList(it)
        }
        viewModel.selectTasksByGroup()
    }
}
