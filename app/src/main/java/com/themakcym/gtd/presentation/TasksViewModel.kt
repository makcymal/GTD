package com.themakcym.gtd.presentation

import androidx.lifecycle.*
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.models.*
import com.themakcym.gtd.domain.usecases.*
import kotlinx.coroutines.launch
import java.util.UUID


class TasksViewModel: ViewModel() {

    var groupId: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")

    private val repo = Dep.repo

    private val createTaskUC = CreateTaskUC(repo)
    private val selectTasksByGroupUC = SelectTasksByGroupUC(repo)

    val tasks = MutableLiveData<List<Task>>()

    fun createTask(title: String, desc: String) {
        viewModelScope.launch {
            createTaskUC.execute(Task(title, groupId, taskDesc = desc))
            selectTasksByGroup()
        }
    }

    fun selectTasksByGroup() {
        viewModelScope.launch {
            tasks.postValue(selectTasksByGroupUC.execute(groupId))
        }
    }
}
