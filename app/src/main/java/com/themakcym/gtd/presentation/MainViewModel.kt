package com.themakcym.gtd.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.models.Task
import com.themakcym.gtd.domain.usecases.*
import kotlinx.coroutines.launch
import java.util.UUID


class MainViewModel : ViewModel() {

    private val repo = Dep.repo

    private val createGroupUC = CreateGroupUC(repo)
    private val getGroupsUC = GetGroupsUC(repo)
    private val selectTasksByGroupUC = SelectTasksByGroupUC(repo)
    private val createTaskUC = CreateTaskUC(repo)
    private val getTasksUC = GetTasksUC(repo)
    private val dropAllUC = DropAllUC(repo)

    private var initialized = false
    var tasks = mutableListOf(MutableLiveData<List<Task>>())
    val groups = MutableLiveData<List<Group>>()

    fun initialize() {
        if (!initialized) {
            viewModelScope.launch {
                dropAllUC.execute()
                val delayed = Group("Delaye", UUID.randomUUID())
                val bucket = Group("Bucke", UUID.randomUUID())
                createGroupUC.execute(delayed)
                createGroupUC.execute(bucket)
                createTaskUC.execute(Task("Go for a walk", bucket.groupId))
                createTaskUC.execute(Task("Have a lunch", bucket.groupId))
                createTaskUC.execute(Task("Do homework", delayed.groupId))
                groups.postValue(getGroupsUC.execute())
                initialized = true
            }
        }
    }

    fun selectTasksByGroup(pos: Int, groupId: UUID) {
        viewModelScope.launch {
            tasks[pos].postValue(selectTasksByGroupUC.execute(groupId))
        }
    }

    fun getTasks() {
        viewModelScope.launch {
            tasks[0].postValue(getTasksUC.execute())
        }
    }

    fun getGroups() {
        viewModelScope.launch {
            groups.postValue(getGroupsUC.execute())
        }
    }
}
