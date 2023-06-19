package com.themakcym.gtd.presentation.viewmodels

import androidx.lifecycle.*
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.models.*
import com.themakcym.gtd.domain.usecases.*
import kotlinx.coroutines.launch
import java.util.UUID


class GroupViewModel: ViewModel() {

    var groupId = UUID.fromString("00000000-0000-0000-0000-000000000000")

    private val repo = Dep.repo

    private val createTaskUC = CreateTaskUC(repo)
    private val selectTasksByGroupUC = SelectTasksByGroupUC(repo)
    private val updateTaskUC = UpdateTaskUC(repo)
    private val checkTaskUC = CheckTaskUC(repo)
    private val deleteTaskUC = DeleteTaskUC(repo)
    private val selectSubtasksUC = SelectSubtasksUC(repo)

    var tasks = mutableListOf<Task>()
    var subtasks = mutableListOf<MutableList<Subtask>>()

    val initialized = MutableLiveData(false)
    val editedPosition = MutableLiveData(0)

    fun createTask(title: String, desc: String) {
        viewModelScope.launch {
            createTaskUC.execute(Task(title, groupId, taskDesc = desc))
            selectTasksByGroup()
        }
    }

    fun selectTasksByGroup() {
        viewModelScope.launch {
            tasks = selectTasksByGroupUC.execute(groupId) as MutableList<Task>
            for (task in tasks) {
                subtasks += selectSubtasksUC.execute(task.taskId) as MutableList<Subtask>
            }
            initialized.postValue(true)
        }
    }

    fun updateTask(task: Task, position: Int) {
        viewModelScope.launch {
            updateTaskUC.execute(task)
            editedPosition.postValue(position)
        }
    }

    fun checkTask(task: Task, position: Int) {
        viewModelScope.launch {
            checkTaskUC.execute(task)
            editedPosition.postValue(position)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUC.execute(task)
            selectTasksByGroup()
        }
    }
}
