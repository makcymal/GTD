package com.themakcym.gtd.data

import com.themakcym.gtd.data.entity.GroupEnt
import com.themakcym.gtd.data.entity.TagEnt
import com.themakcym.gtd.data.entity.TaskEnt
import com.themakcym.gtd.data.entity.TaskTagRel
import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.models.Tag
import com.themakcym.gtd.domain.models.Task
import java.util.UUID
import java.time.LocalDateTime


class Mapper {
    fun groupIntoEnt(group: Group): GroupEnt {
        if (group.isUndefined()) {
            return GroupEnt(group.groupTitle, UUID.randomUUID())
        }
        return GroupEnt(group.groupTitle, group.groupId)
    }

    fun groupFromEnt(ent: GroupEnt): Group {
        return Group(ent.groupTitle, ent.groupId)
    }

    fun tagIntoEnt(tag: Tag): TagEnt {
        if (tag.isUndefined()) {
            return TagEnt(tag.tagTitle, UUID.randomUUID())
        }
        return TagEnt(tag.tagTitle, tag.tagId)
    }

    fun tagFromEnt(ent: TagEnt): Tag {
        return Tag(ent.tagTitle, ent.tagId)
    }

    fun taskIntoEnt(task: Task): TaskEnt {
        val taskId = if (task.isUndefined()) {
            UUID.randomUUID()
        } else {
            task.taskId
        }
        return TaskEnt(
            task.taskTitle,
            task.groupId,
            taskId,
            task.taskDesc,
            task.isCompleted,
            task.taskUpdated.toString()
        )
    }

    fun taskIntoRel(task: Task): List<TaskTagRel> {
        val list = mutableListOf<TaskTagRel>()
        for (tagId in task.tagsIds) {
            list += TaskTagRel(task.taskId, tagId)
        }
        return list
    }

    fun taskFromEnt(taskEnt: TaskEnt, tagsIds: List<UUID>): Task {
        return Task(
            taskEnt.taskTitle,
            taskEnt.groupId,
            taskEnt.taskId,
            taskEnt.taskDesc,
            taskEnt.isCompleted,
            LocalDateTime.parse(taskEnt.taskUpdated),
            tagsIds,
        )
    }
}