package com.themakcym.gtd.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.textfield.TextInputEditText
import com.themakcym.gtd.domain.models.Subtask
import com.themakcym.gtd.R
import com.themakcym.gtd.presentation.viewmodels.SubtasksViewModel


class SubtaskAdapter(private val viewModel: SubtasksViewModel) :
    ListAdapter<Subtask, SubtaskAdapter.SubtaskViewHolder>(
        CallBack()
    ) {

    class SubtaskViewHolder(view: View) : ViewHolder(view) {
        val checker: CheckBox = view.findViewById(R.id.checker)
        val input: TextInputEditText = view.findViewById(R.id.editSubtaskDetailsInput)
        val trash: ImageButton = view.findViewById(R.id.subtaskTrashBtn)
    }

    class CallBack : DiffUtil.ItemCallback<Subtask>() {
        override fun areItemsTheSame(oldItem: Subtask, newItem: Subtask): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Subtask, newItem: Subtask): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubtaskViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.subtask_layout, parent, false)
        return SubtaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubtaskViewHolder, position: Int) {
        holder.checker.isChecked = viewModel.subtasks[holder.adapterPosition].isCompleted
        holder.input.setText(viewModel.subtasks[holder.adapterPosition].subtaskDetails)

        holder.checker.setOnClickListener {
            viewModel.checkSubtask(holder.adapterPosition)
        }

        holder.input.addTextChangedListener {
            val input = it!!.toString()
            if (input != viewModel.subtasks[holder.adapterPosition].subtaskDetails) {
                viewModel.updateSubtask(input, holder.adapterPosition)
                holder.input.requestFocus()
            }
        }

        holder.trash.setOnClickListener {
            viewModel.deleteSubtask(holder.adapterPosition)
        }
    }
}