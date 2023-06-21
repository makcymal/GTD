package com.themakcym.gtd.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.themakcym.gtd.databinding.NewGroupSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.themakcym.gtd.presentation.viewmodels.GroupsViewModel


class NewGroupSheet : BottomSheetDialogFragment() {
    private lateinit var binding: NewGroupSheetBinding
    private lateinit var viewModel: GroupsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[GroupsViewModel::class.java]
        binding.createGroupBtn.setOnClickListener {
            newGroupAction()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = NewGroupSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun newGroupAction() {
        viewModel.newGroup.postValue(
                binding.newGroupTitleInput.text.toString()
        )
        binding.newGroupTitleInput.setText("")
        dismiss()
    }
}