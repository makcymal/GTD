package com.themakcym.gtd.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.themakcym.gtd.databinding.TaskDialogBinding
import com.themakcym.gtd.domain.models.Task
import com.themakcym.gtd.presentation.viewmodels.TasksViewModel
import com.themakcym.gtd.R
import com.themakcym.gtd.presentation.adapters.SubtaskAdapter
import java.time.format.DateTimeFormatter


class TaskDialog(
    private val task: Task,
    private val viewModel: TasksViewModel,
    private val position: Int
) : DialogFragment() {

    private lateinit var binding: TaskDialogBinding
    private lateinit var rvAdapter: SubtaskAdapter
    private val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yy hh:mm")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = TaskDialogBinding.inflate(inflater, container, false)
        viewModel.subtasksVM[position].task = task
        rvAdapter = SubtaskAdapter(viewModel.subtasksVM[position])
        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.DialogStyle
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.subtasksRV.adapter = rvAdapter
        binding.subtasksRV.layoutManager = LinearLayoutManager(requireActivity())

        "updated at ${task.taskUpdated.format(dateTimeFormatter)}".also {
            binding.updatedTV.text = it
        }
        binding.editTaskTitleInput.setText(task.taskTitle)
        binding.editTaskDescInput.setText(task.taskDesc)

        binding.taskDialogCommitBtn.setOnClickListener {
            task.taskTitle = binding.editTaskTitleInput.text.toString()
            task.taskDesc = binding.editTaskDescInput.text.toString()
            viewModel.updateTask(task, position)
            viewModel.subtasksVM[position].commitSubtasks()
            dismiss()
        }

        binding.taskDialogCancelBtn.setOnClickListener {
            viewModel.subtasksVM[position].selectSubtasks()
            dismiss()
        }

        binding.moveTaskToTrashBtn.setOnClickListener {
            viewModel.deleteTask(task)
            viewModel.subtasksVM.removeAt(position)
            dismiss()
        }

        binding.newSubtaskBtn.setOnClickListener {
            viewModel.subtasksVM[position].createSubtask()
            rvAdapter.notifyDataSetChanged()
        }

        viewModel.subtasksVM[position].notifier.observe(this) {
            rvAdapter.submitList(viewModel.subtasksVM[position].subtasks)
            rvAdapter.notifyDataSetChanged()
        }
        viewModel.subtasksVM[position].selectSubtasks()
    }
}