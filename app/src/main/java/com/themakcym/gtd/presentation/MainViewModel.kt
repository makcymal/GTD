package com.themakcym.gtd.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.models.Tag
import com.themakcym.gtd.domain.usecases.*
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val repo = Dep.repo

    private val createTaskUC = CreateTaskUC(repo)
    private val renameTaskUC = RenameTaskUC(repo)
    private val describeTaskUC = DescribeTaskUC(repo)
    private val moveTaskUC = MoveTaskUC(repo)
    private val checkCompletionTaskUC = CheckCompletionTaskUC(repo)
    private val tagTaskUC = TagTaskUC(repo)
    private val untagTaskUC = UntagTaskUC(repo)
    private val deleteTaskUC = DeleteTaskUC(repo)

    private val createGroupUC = CreateGroupUC(repo)
    private val renameGroupUC = RenameGroupUC(repo)
    private val deleteGroupUC = DeleteGroupUC(repo)
    private val selectGroupsUC = SelectGroupsUC(repo)

    private val createTagUC = CreateTagUC(repo)
    private val renameTagUC = RenameTagUC(repo)
    private val deleteTagUc = DeleteTagUC(repo)
    private val selectTagsUC = SelectTagsUC(repo)

    // all available groups listed in TabLayout
    val groups = MutableLiveData<List<Group>>()
    // all available tags listed between TabLayout with groups and Fragment with tasks
    val tags = MutableLiveData<List<Tag>>()

    fun selectGroups() {
        viewModelScope.launch {
            groups.postValue(selectGroupsUC.execute())
        }
    }

    fun selectTags() {
        viewModelScope.launch {
            tags.postValue(selectTagsUC.execute())
        }
    }
}
