package com.themakcym.gtd.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.themakcym.gtd.R
import com.themakcym.gtd.databinding.GroupDialogBinding
import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.presentation.viewmodels.MainViewModel


class GroupDialog(private val group: Group, private val viewModel: MainViewModel) : DialogFragment() {

    private lateinit var binding: GroupDialogBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = GroupDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.DialogStyle
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editGroupTitleInput.setText(group.groupTitle)

        binding.editGroupFab.setOnClickListener {
            group.groupTitle = binding.editGroupTitleInput.text.toString()
            viewModel.updateGroup(group)
            dismiss()
        }

        binding.groupDialogCancelBtn.setOnClickListener {
            dismiss()
        }

        binding.moveGroupToTrashBtn.setOnClickListener {
            viewModel.deleteGroup(group)
            dismiss()
        }
    }
}