package com.themakcym.gtd.domain.usecases

import com.themakcym.gtd.data.models.Tag
import com.themakcym.gtd.domain.Repository

class AddTagUC(private val repository: Repository) {
    suspend fun execute(tag: Tag) {
        repository.createTag(tag)
    }
}

class RenameTagUC(private val repository: Repository) {
    suspend fun execute(tag: Tag, tagTitle: String) {
        tag.tagTitle = tagTitle
        repository.updateTag(tag)
    }
}

class DeleteTagUC(private val repository: Repository) {
    suspend fun execute(tag: Tag) {
        repository.deleteTag(tag)
    }
}

class GetTagsListUC(private val repository: Repository) {
    suspend fun execute() : List<Tag> {
        return repository.getTagsList()
    }
}
