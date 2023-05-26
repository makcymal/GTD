package com.themakcym.gtd.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.models.Tag
import com.themakcym.gtd.domain.models.Task
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
    private val selectTasksByGroup = SelectTasksByGroup(repo)

    private val addGroupUC = AddGroupUC(repo)
    private val renameGroupUC = RenameGroupUC(repo)
    private val deleteGroupUC = DeleteGroupUC(repo)
    private val getGroupsListUC = GetGroupsListUC(repo)

    private val addTagUC = AddTagUC(repo)
    private val renameTagUC = RenameTagUC(repo)
    private val deleteTagUc = DeleteTagUC(repo)
    private val getTagsListUC = GetTagsListUC(repo)

    // tasks shown in current fragment
    val tasks = MutableLiveData<List<Task>>()
    // all available groups listed in TabLayout
    val groupsList = MutableLiveData<List<Group>>()
    // index of actual chosen group
    val actualGroup = MutableLiveData<Int>()
    // all available tags listed between TabLayout with groups and Fragment with tasks
    val tagsList = MutableLiveData<List<Tag>>()
    // indices of actual chosen tags
    val actualTags = MutableLiveData<List<Int>>()

    fun getGroupsList() {
        viewModelScope.launch {
            groupsList.postValue(getGroupsListUC.execute())
        }
    }

    fun newGroup(groupTitle: String) {
        viewModelScope.launch {
            addGroupUC.execute(Group(groupTitle = groupTitle))
        }
    }
}
