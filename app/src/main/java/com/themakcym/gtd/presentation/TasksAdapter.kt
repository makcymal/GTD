package com.themakcym.gtd.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.themakcym.gtd.R
import com.themakcym.gtd.domain.models.Task


class TasksAdapter() : ListAdapter<Task, TasksAdapter.TaskViewHolder>(
    CallBack()
) {

    // MainActivity context
    private lateinit var context: Context

    // view - CardView with single task
    class TaskViewHolder(view: View) : ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.nameTV)
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
//        holder.itemView.setOnClickListener {
//            context.startActivity(TaskActivity.getIntent(context, currentList[position].taskTitle))
//        }
    }
}
