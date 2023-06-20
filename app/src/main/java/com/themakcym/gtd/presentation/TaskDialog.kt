package com.themakcym.gtd.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.themakcym.gtd.databinding.TaskDialogBinding
import com.themakcym.gtd.domain.models.Task
import com.themakcym.gtd.presentation.viewmodels.GroupViewModel
import com.themakcym.gtd.R
import java.time.format.DateTimeFormatter


class TaskDialog(
    private val task: Task,
    private val viewModel: GroupViewModel,
    private val position: Int
) : DialogFragment() {

    private lateinit var binding: TaskDialogBinding
    private val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yy hh:mm")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = TaskDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.DialogStyle
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        "updated at ${task.taskUpdated.format(dateTimeFormatter)}".also {
            binding.updatedTV.text = it
        }
        binding.editTaskTitleInput.setText(task.taskTitle)
        binding.editTaskDescInput.setText(task.taskDesc)

        binding.editTaskFab.setOnClickListener {
            task.taskTitle = binding.editTaskTitleInput.text.toString()
            task.taskDesc = binding.editTaskDescInput.text.toString()
            viewModel.updateTask(task, position)
            dismiss()
        }

        binding.taskDialogCancelBtn.setOnClickListener {
            dismiss()
        }

        binding.moveTaskToTrashBtn.setOnClickListener {
            viewModel.deleteTask(task)
            dismiss()
        }
    }
}