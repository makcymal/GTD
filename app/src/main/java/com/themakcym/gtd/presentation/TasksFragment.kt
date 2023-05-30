package com.themakcym.gtd.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.themakcym.gtd.databinding.TasksFragmentBinding
import com.themakcym.gtd.domain.models.Task
import java.util.UUID


class TasksFragment(private val tasks: MutableLiveData<List<Task>>) : Fragment() {

    private lateinit var binding: TasksFragmentBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = TasksFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TasksAdapter()
        binding.tasksRecycler.adapter = adapter
        tasks.observe(requireActivity()) {
            adapter.submitTasks(it)
        }
        viewModel.getTasks()

        binding.tasksRecycler.layoutManager = LinearLayoutManager(requireActivity())


    }
}