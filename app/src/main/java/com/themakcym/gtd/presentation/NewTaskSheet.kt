package com.themakcym.gtd.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.themakcym.gtd.databinding.NewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.themakcym.gtd.presentation.viewmodels.NewTaskViewModel


class NewTaskSheet : BottomSheetDialogFragment()
{
    private lateinit var binding: NewTaskSheetBinding
    private lateinit var newTaskViewModel: NewTaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newTaskViewModel = ViewModelProvider(requireActivity())[NewTaskViewModel::class.java]
        binding.saveButton.setOnClickListener {
            newTaskAction()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = NewTaskSheetBinding.inflate(inflater,container,false)
        return binding.root
    }


    private fun newTaskAction() {
        newTaskViewModel.title_desc.postValue(
            Pair(
                binding.newTitleInput.text.toString(),
                binding.newDescInput.text.toString()
            )
        )
        binding.newTitleInput.setText("")
        binding.newDescInput.setText("")
        dismiss()
    }
}