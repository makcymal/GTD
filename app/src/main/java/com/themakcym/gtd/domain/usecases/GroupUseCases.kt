package com.themakcym.gtd.domain.usecases

import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.Repository


class InitGroupsUC(private val repo: Repository) {
    suspend fun execute() {
        if (repo.getGroups().isEmpty()) {
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

class UpdateGroupUC(private val repo: Repository) {
    suspend fun execute(group: Group) {
        repo.updateGroup(group)
    }
}

class DeleteGroupUC(private val repo: Repository) {
    suspend fun execute(group: Group) {
        repo.deleteGroup(group)
    }
}

class GetGroupsUC(private val repo: Repository) {
    suspend fun execute() : List<Group> {
        return repo.getGroups()
    }
}

class DropGroupsUC(private val repo: Repository) {
    suspend fun execute() {
        repo.dropGroups()
    }
}
