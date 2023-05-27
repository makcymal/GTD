package com.themakcym.gtd.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.themakcym.gtd.data.models.Task
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.usecases.GetTasksByGroupUC
import kotlinx.coroutines.launch
import java.util.UUID


class TasksViewModel(private val groupId: UUID) : ViewModel() {

    private val tasks = MutableLiveData<List<Task>>()

    private val repo = Dep.repo

    private val getTasksByGroupUC = GetTasksByGroupUC(repo)

    fun getTasksByGroup() {
        viewModelScope.launch {
            tasks.postValue(getTasksByGroupUC.execute(groupId))
        }
    }
}