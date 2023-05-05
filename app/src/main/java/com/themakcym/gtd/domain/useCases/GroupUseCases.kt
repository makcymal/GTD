package com.themakcym.gtd.domain.useCases

import com.themakcym.gtd.data.Group
import com.themakcym.gtd.domain.Repository

class AddGroupUC(private val repository: Repository) {
    fun execute(group: Group) {
        repository.createGroup(group)
    }
}

class RenameGroupUC(private val repository: Repository) {
    fun execute(group: Group, groupTitle: String) {
        group.groupTitle = groupTitle
        repository.updateGroup(group)
    }
}

class DeleteGroupUC(private val repository: Repository) {
    fun execute(group: Group) {
        repository.deleteGroup(group)
    }
}

class GetGroupsListUC(private val repository: Repository) {
    fun execute() : List<Group> {
        return repository.getGroupsList()
    }
}
