package com.themakcym.gtd.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.themakcym.gtd.data.models.*
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.usecases.*
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val repo = Dep.repo

    private val addTaskUC = AddTaskUC(repo)
    private val renameTaskUC = RenameTaskUC(repo)
    private val describeTaskUC = DescribeTaskUC(repo)
    private val moveTaskUC = MoveTaskUC(repo)
    private val completeTaskUC = CompleteTaskUC(repo)
    private val incompleteTaskUC = IncompleteTaskUC(repo)
    private val tagTaskUC = TagTaskUC(repo)
    private val untagTaskUC = UntagTaskUC(repo)
    private val deleteTaskUC = DeleteTaskUC(repo)

    private val addGroupUC = AddGroupUC(repo)
    private val renameGroupUC = RenameGroupUC(repo)
    private val deleteGroupUC = DeleteGroupUC(repo)
    private val getGroupsListUC = GetGroupsListUC(repo)

    private val addTagUC = AddTagUC(repo)
    private val renameTagUC = RenameTagUC(repo)
    private val deleteTagUc = DeleteTagUC(repo)
    private val getTagsListUC = GetTagsListUC(repo)

    // all available groups listed in TabLayout
    val groupsList = MutableLiveData<List<Group>>()
    // all available tags listed between TabLayout with groups and Fragment with tasks
    val tagsList = MutableLiveData<List<Tag>>()

    fun getGroupsList() {
        viewModelScope.launch {
            groupsList.postValue(getGroupsListUC.execute())
        }
    }

    fun addGroup(title: String) {
        viewModelScope.launch {
            addGroupUC.execute(Group(groupTitle = title))
            getGroupsList()
        }
    }
}
