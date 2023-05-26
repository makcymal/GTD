package com.themakcym.gtd.domain.usecases

import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.Repository

class AddGroupUC(private val repository: Repository) {
    suspend fun execute(group: Group) {
        repository.createGroup(group)
    }
}

class RenameGroupUC(private val repository: Repository) {
    suspend fun execute(group: Group, groupTitle: String) {
        group.groupTitle = groupTitle
        repository.updateGroup(group)
    }
}

class DeleteGroupUC(private val repository: Repository) {
    suspend fun execute(group: Group) {
        repository.deleteGroup(group)
    }
}

class GetGroupsListUC(private val repository: Repository) {
    suspend fun execute() : List<Group> {
        return repository.getGroupsList()
    }
}
