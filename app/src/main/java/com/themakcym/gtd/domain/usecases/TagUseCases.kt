package com.themakcym.gtd.domain.usecases

import com.themakcym.gtd.domain.models.Tag
import com.themakcym.gtd.domain.Repository


class CreateTagUC(private val repo: Repository) {
    suspend fun execute(tag: Tag) {
        repo.insertTag(tag)
    }
}

class RenameTagUC(private val repo: Repository) {
    suspend fun execute(tag: Tag, tagTitle: String) {
        tag.tagTitle = tagTitle
        repo.updateTag(tag)
    }
}

class DeleteTagUC(private val repo: Repository) {
    suspend fun execute(tag: Tag) {
        repo.deleteTag(tag)
    }
}

class SelectTagsUC(private val repo: Repository) {
    suspend fun execute() : List<Tag> {
        return repo.selectTags()
    }
}
