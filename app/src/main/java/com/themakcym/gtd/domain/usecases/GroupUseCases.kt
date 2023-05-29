package com.themakcym.gtd.domain.usecases

import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.Repository


class InitGroupsUC(private val repo: Repository) {
    suspend fun execute() {
        if (repo.selectGroups().isEmpty()) {
            repo.createGroup(Group("Bucket"))
            repo.createGroup(Group("Delayed"))
        }
    }
}


class CreateGroupUC(private val repo: Repository) {
    suspend fun execute(group: Group) {
        repo.createGroup(group)
    }
}

class RenameGroupUC(private val repo: Repository) {
    suspend fun execute(group: Group, groupTitle: String) {
        group.groupTitle = groupTitle
        repo.updateGroup(group)
    }
}

class DeleteGroupUC(private val repo: Repository) {
    suspend fun execute(group: Group) {
        repo.deleteGroup(group)
    }
}

class SelectGroupsUC(private val repo: Repository) {
    suspend fun execute() : List<Group> {
        return repo.selectGroups()
    }
}
