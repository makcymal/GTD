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
        return R.style.EditTaskStyle
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTitleInput.setText(task.taskTitle)
        binding.editDescInput.setText(task.taskDesc)

        binding.editTaskFAB.setOnClickListener {
            task.taskTitle = binding.editTitleInput.text.toString()
            task.taskDesc = binding.editDescInput.text.toString()
            viewModel.updateTask(task)
            dismiss()
        }

        binding.dialogCancelBtn.setOnClickListener {
            dismiss()
        }
    }
}