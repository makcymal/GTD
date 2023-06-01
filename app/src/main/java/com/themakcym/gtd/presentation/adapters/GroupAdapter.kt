package com.themakcym.gtd.presentation.adapters

import android.view.*
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.themakcym.gtd.R
import com.themakcym.gtd.domain.models.Task


class GroupAdapter() : ListAdapter<Task, GroupAdapter.TaskViewHolder>(
    CallBack()
) {

    // view - CardView with single task
    class TaskViewHolder(val view: View) : ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.nameTV)
        val checker: CheckBox = view.findViewById(R.id.checker)
    }

    class CallBack : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.taskId == newItem.taskId
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_layout, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.name.text = currentList[position].taskTitle
        holder.checker.isChecked = currentList[position].isCompleted

        holder.view.setOnClickListener {

        }
    }
}
