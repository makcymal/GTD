package com.themakcym.gtd.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.themakcym.gtd.databinding.TasksFragmentBinding
import com.themakcym.gtd.presentation.adapters.TasksAdapter
import com.themakcym.gtd.presentation.viewmodels.TasksViewModel
import java.util.UUID


class TasksFragment(private val groupId: UUID) : Fragment() {

    private lateinit var binding: TasksFragmentBinding

    lateinit var viewModel: TasksViewModel
    private lateinit var rvAdapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = TasksFragmentBinding
            .inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TasksViewModel::class.java]
        viewModel.groupId = groupId
        rvAdapter = TasksAdapter(viewModel, requireActivity())
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tasksRV.adapter = rvAdapter
        binding.tasksRV.layoutManager = LinearLayoutManager(requireActivity())

        viewModel.notifier.observe(viewLifecycleOwner) {
            rvAdapter.submitList(viewModel.tasks)
            rvAdapter.notifyDataSetChanged()
        }
        viewModel.selectTasksByGroup()

        viewModel.editedTaskPos.observe(viewLifecycleOwner) {
            rvAdapter.notifyItemChanged(it)
        }
    }
}
