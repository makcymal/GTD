package com.themakcym.gtd.data

import com.themakcym.gtd.domain.models.Group
import com.themakcym.gtd.domain.models.Tag
import com.themakcym.gtd.domain.models.Task
import com.themakcym.gtd.data.room.entities.GroupEntity
import com.themakcym.gtd.data.room.entities.TagEntity
import com.themakcym.gtd.data.room.entities.TaskEntity

class Mapper {
    fun groupToGroupEntity(group: Group): GroupEntity {
        if (group.isUndefined()) {
            return GroupEntity(groupTitle = group.groupTitle)
        }
        return GroupEntity(groupId = group.groupId, groupTitle = group.groupTitle)
    }

    fun groupEntityToGroup(entity: GroupEntity): Group {
        return Group(groupId = entity.groupId, groupTitle = entity.groupTitle)
    }

    fun tagToTagEntity(tag: Tag): TagEntity {
        if (tag.isUndefined()) {
            return TagEntity(tagTitle = tag.tagTitle)
        }
        return TagEntity(tagId = tag.tagId, tagTitle = tag.tagTitle)
    }

    fun tagEntityToTag(entity: TagEntity): Tag {
        return Tag(tagId = entity.tagId, tagTitle = entity.tagTitle)
    }

    fun taskToTaskEntity(task: Task): TaskEntity {
        if (task.isUndefined()) {
            return TaskEntity(
                taskId = task.taskId,
                taskTitle = task.taskTitle,
                taskDescription = task.taskDescription,
                isCompleted = task.isCompleted,
                taskUpdated = task.taskUpdated,
                taskGroup = task.taskGroup,
                taskTags = task.taskTags,
            )
        }
        return TaskEntity(
            taskTitle = task.taskTitle,
            taskDescription = task.taskDescription,
            isCompleted = task.isCompleted,
            taskUpdated = task.taskUpdated,
            taskGroup = task.taskGroup,
            taskTags = task.taskTags,
        )
    }

    fun taskEntityToTask(entity: TaskEntity): Task {
        return Task(
            taskId = entity.taskId,
            taskTitle = entity.taskTitle,
            taskDescription = entity.taskDescription,
            isCompleted = entity.isCompleted,
            taskUpdated = entity.taskUpdated,
            taskGroup = entity.taskGroup,
            taskTags = entity.taskTags,
        )
    }
}