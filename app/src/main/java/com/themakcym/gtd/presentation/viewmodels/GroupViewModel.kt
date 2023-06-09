package com.themakcym.gtd.presentation.viewmodels

import androidx.lifecycle.*
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.models.*
import com.themakcym.gtd.domain.usecases.*
import kotlinx.coroutines.launch
import java.util.UUID


class GroupViewModel: ViewModel() {

    var groupId: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")

    private val repo = Dep.repo

    private val createTaskUC = CreateTaskUC(repo)
    private val selectTasksByGroupUC = SelectTasksByGroupUC(repo)
    private val updateTaskUC = UpdateTaskUC(repo)

    val tasks = MutableLiveData<List<Task>>()
    val editedTask = MutableLiveData<Task>()
    var editedTaskPos: Int? = null

    private val selectSubtasksUC = SelectSubtasksUC(repo)

    val subtasks: MutableList<List<Subtask>> = mutableListOf()

    fun createTask(title: String, desc: String) {
        viewModelScope.launch {
            createTaskUC.execute(Task(title, groupId, taskDesc = desc))
            selectTasksByGroup()
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            updateTaskUC.execute(task)
            selectTasksByGroup()
        }
    }

    fun selectTasksByGroup() {
        viewModelScope.launch {
            val t = selectTasksByGroupUC.execute(groupId)
//            for (task in t) {
//                subtasks += selectSubtasksUC.execute(task.taskId)
//            }
            tasks.postValue(t)
        }
    }
}
