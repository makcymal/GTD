package com.themakcym.gtd.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.themakcym.gtd.databinding.NewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.themakcym.gtd.presentation.viewmodels.MainViewModel


class NewTaskSheet : BottomSheetDialogFragment() {
    private lateinit var binding: NewTaskSheetBinding
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        binding.createTaskBtn.setOnClickListener {
            newTaskAction()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = NewTaskSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun newTaskAction() {
        viewModel.newTask.postValue(
            Pair(
                binding.newTaskTitleInput.text.toString(),
                binding.newTaskDescInput.text.toString()
            )
        )
        binding.newTaskTitleInput.setText("")
        binding.newTaskDescInput.setText("")
        dismiss()
    }
}