package com.themakcym.gtd.presentation.adapters

import android.view.*
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.themakcym.gtd.R
import com.themakcym.gtd.domain.models.Task
import com.themakcym.gtd.presentation.TaskDialog
import com.themakcym.gtd.presentation.viewmodels.TasksViewModel


class TasksAdapter(private val viewModel: TasksViewModel, private val activity: FragmentActivity) : ListAdapter<Task, TasksAdapter.TaskViewHolder>(
    CallBack()
) {

    // view - CardView with single task
    class TaskViewHolder(val view: View) : ViewHolder(view) {
        val checker: CheckBox = view.findViewById(R.id.checker)
        val name: TextView = view.findViewById(R.id.nameTV)
        val star: ImageButton = view.findViewById(R.id.taskStarBtn)
    }

    class CallBack : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
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
        holder.checker.isChecked = currentList[holder.adapterPosition].isCompleted
        holder.name.text = currentList[holder.adapterPosition].taskTitle
        if (currentList[holder.adapterPosition].isStarred) {
            holder.star.setImageResource(R.drawable.baseline_star_32)
        } else {
            holder.star.setImageResource(R.drawable.baseline_star_outline_32)
        }

        holder.checker.setOnClickListener {
            viewModel.checkTask(currentList[holder.adapterPosition], holder.adapterPosition)
        }

        holder.view.setOnClickListener {
            val taskDialog = TaskDialog(currentList[holder.adapterPosition], viewModel, holder.adapterPosition)
            taskDialog.show(activity.supportFragmentManager, "taskDialog")
        }

        holder.star.setOnClickListener {
            viewModel.starTask(currentList[holder.adapterPosition], holder.adapterPosition)
        }
    }
}
