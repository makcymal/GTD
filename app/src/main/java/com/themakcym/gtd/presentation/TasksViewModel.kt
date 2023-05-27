package com.themakcym.gtd.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.themakcym.gtd.domain.models.Task
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.usecases.SelectTasksByGroupUC
import kotlinx.coroutines.launch
import java.util.UUID


class TasksViewModel : ViewModel() {

    lateinit var groupId: UUID

    private val tasks = MutableLiveData<List<Task>>()

    private val repo = Dep.repo

    private val getTasksByGroupUC = SelectTasksByGroupUC(repo)

    fun getTasksByGroup() {
        viewModelScope.launch {
            tasks.postValue(getTasksByGroupUC.execute(groupId))
        }
    }
}