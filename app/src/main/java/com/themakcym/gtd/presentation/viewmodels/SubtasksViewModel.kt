package com.themakcym.gtd.presentation.viewmodels

import androidx.lifecycle.*
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.models.*
import com.themakcym.gtd.domain.usecases.*
import kotlinx.coroutines.launch


class SubtasksViewModel : ViewModel() {

    var task: Task? = null

    private val repo = Dep.repo

    private val createSubtaskUC = CreateSubtaskUC(repo)
    private val deleteSubtasksByTaskUC = DeleteSubtasksByTaskUC(repo)
    private val selectSubtasksByTaskUC = SelectSubtasksByTaskUC(repo)

    var subtasks = mutableListOf<Subtask>()
    val notifier = MutableLiveData(false)

    fun selectSubtasks() {
        if (task == null) return
        viewModelScope.launch {
            subtasks = selectSubtasksByTaskUC.execute(task!!.taskId) as MutableList<Subtask>
            notifier.postValue(true)
        }
    }

    fun createSubtask() {
        if (task == null) return
        subtasks.add(0, Subtask(task!!.taskId, task!!.nextSubtaskId()))
        notifier.postValue(true)
    }

    fun updateSubtask(details: String, position: Int) {
        subtasks[position].subtaskDetails = details
    }

    fun checkSubtask(position: Int) {
        subtasks[position].isCompleted = !subtasks[position].isCompleted
        subtasks.sortBy { it.isCompleted }
        notifier.postValue(true)
    }

    fun deleteSubtask(position: Int) {
        subtasks.removeAt(position)
        notifier.postValue(true)
    }

    fun commitSubtasks() {
        viewModelScope.launch {
            deleteSubtasksByTaskUC.execute(task!!.taskId)
            for (subtask in subtasks) {
                createSubtaskUC.execute(subtask)
            }
        }
    }
}
