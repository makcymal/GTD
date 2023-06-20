package com.themakcym.gtd.presentation.viewmodels

import androidx.lifecycle.*
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.models.*
import com.themakcym.gtd.domain.usecases.*
import kotlinx.coroutines.launch
import java.util.UUID


class MainViewModel : ViewModel() {

    private val repo = Dep.repo

    private val createGroupUC = CreateGroupUC(repo)
    private val retrieveGroupUC = RetrieveGroupUC(repo)
    private val updateGroupUC = UpdateGroupUC(repo)
    private val deleteGroupUC = DeleteGroupUC(repo)
    private val selectGroupsUC = SelectGroupsUC(repo)

    val notifier = MutableLiveData(false)
    val updatedGroupPos = MutableLiveData(0)

    var groups = mutableListOf<Group>()

    fun createGroup(title: String) {
        viewModelScope.launch {
            createGroupUC.execute(Group(title))
            groups = selectGroupsUC.execute() as MutableList<Group>
            notifier.postValue(true)
        }
    }

    fun updateGroup(group: Group, position: Int) {
        viewModelScope.launch {
            updateGroupUC.execute(group)
            groups[position] = retrieveGroupUC.execute(group.groupId)
            updatedGroupPos.postValue(position)
        }
    }

    fun deleteGroup(group: Group) {
        viewModelScope.launch {
            deleteGroupUC.execute(group)
            groups = selectGroupsUC.execute() as MutableList<Group>
            notifier.postValue(true)
        }
    }

    fun selectGroups() {
        viewModelScope.launch {
            groups = selectGroupsUC.execute() as MutableList<Group>
            notifier.postValue(true)
        }
    }

    val newTask = MutableLiveData<Pair<String, String>>()
    val newGroup = MutableLiveData<String>()
}
