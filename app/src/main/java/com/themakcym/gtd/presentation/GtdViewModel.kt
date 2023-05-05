package com.themakcym.gtd.presentation

import androidx.lifecycle.ViewModel
import com.themakcym.gtd.domain.useCases.*

class GtdViewModel : ViewModel() {

    private val addTaskUC = AddTaskUC()
    private val renameTaskUC = RenameTaskUC()
    private val describeTaskUC = DescribeTaskUC()
    private val moveTaskUC = MoveTaskUC()
    private val completeTaskUC = CompleteTaskUC()
    private val incompleteTaskUC = IncompleteTaskUC()
    private val tagTaskUC = TagTaskUC()
    private val untagTaskUC = UntagTaskUC()
    private val deleteTaskUC = DeleteTaskUC()
    private val selectTasksByGroup = SelectTasksByGroup()

    private val addGroupUC = AddGroupUC()
    private val renameGroupUC = RenameGroupUC()
    private val deleteGroupUC = DeleteGroupUC()
    private val getGroupsListUC = GetGroupsListUC()

    private val addTagUC = AddTagUC()
    private val renameTagUC = RenameTagUC()
    private val deleteTagUc = DeleteTagUC()
    private val getTagsListUC = GetTagsListUC()

}