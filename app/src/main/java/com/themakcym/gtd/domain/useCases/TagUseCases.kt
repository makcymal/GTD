package com.themakcym.gtd.domain.useCases

import com.themakcym.gtd.data.Tag
import com.themakcym.gtd.domain.Repository

class AddTagUC(private val repository: Repository) {
    fun execute(tag: Tag) {
        repository.createTag(tag)
    }
}

class RenameTagUC(private val repository: Repository) {
    fun execute(tag: Tag, tagTitle: String) {
        tag.tagTitle = tagTitle
        repository.updateTag(tag)
    }
}

class DeleteTagUC(private val repository: Repository) {
    fun execute(tag: Tag) {
        repository.deleteTag(tag)
    }
}

class GetTagsListUC(private val repository: Repository) {
    fun execute() : List<Tag> {
        return repository.getTagsList()
    }
}
