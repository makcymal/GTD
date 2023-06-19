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


class TaskDialog(private val task: Task, private val viewModel: GroupViewModel) : DialogFragment() {

    private lateinit var binding: TaskDialogBinding


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

        binding.editTaskTitleInput.setText(task.taskTitle)
        binding.editTaskDescInput.setText(task.taskDesc)

        binding.editTaskFab.setOnClickListener {
            task.taskTitle = binding.editTaskTitleInput.text.toString()
            task.taskDesc = binding.editTaskDescInput.text.toString()
            viewModel.updateTask(task)
            dismiss()
        }

        binding.taskDialogCancelBtn.setOnClickListener {
            dismiss()
        }
    }
}