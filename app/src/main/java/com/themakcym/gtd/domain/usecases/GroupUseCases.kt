package com.themakcym.gtd.domain.usecases

import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.Repository
import java.util.UUID


class CreateGroupUC(private val repo: Repository) {
    suspend fun execute(group: Group) {
        repo.createGroup(group)
    }
}

class RetrieveGroupUC(private val repo: Repository) {
    suspend fun execute(groupId: UUID): Group {
        return repo.retrieveGroup(groupId)
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

class SelectGroupsUC(private val repo: Repository) {
    suspend fun execute() : List<Group> {
        return repo.selectGroups()
    }
}
