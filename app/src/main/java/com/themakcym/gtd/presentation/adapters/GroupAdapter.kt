package com.themakcym.gtd.presentation.adapters

import android.view.*
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.themakcym.gtd.R
import com.themakcym.gtd.domain.models.Task
import com.themakcym.gtd.presentation.TaskDialog
import com.themakcym.gtd.presentation.viewmodels.GroupViewModel


class GroupAdapter(private val viewModel: GroupViewModel, private val activity: FragmentActivity) : ListAdapter<Task, GroupAdapter.TaskViewHolder>(
    CallBack()
) {

    // view - CardView with single task
    class TaskViewHolder(val view: View) : ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.nameTV)
        val checker: CheckBox = view.findViewById(R.id.checker)
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
//        holder.name.text = currentList[position].taskTitle
        holder.name.text = position.toString()
        holder.checker.isChecked = currentList[position].isCompleted

//        println("inside item at $position")

        holder.view.setOnClickListener {
            val taskDialog = TaskDialog(currentList[position], viewModel, position)
            taskDialog.show(activity.supportFragmentManager, "taskDialog")
        }

        holder.checker.setOnClickListener {
            viewModel.checkTask(currentList[position], position)
        }
    }
}
