package com.themakcym.gtd.data

import com.themakcym.gtd.data.entity.*
import com.themakcym.gtd.domain.models.*
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
            task.isStarred,
            task.taskUpdated.toString()
        )
    }

    fun taskFromEnt(ent: TaskEnt): Task {
        return Task(
            ent.taskTitle,
            ent.groupId,
            ent.taskId,
            ent.taskDesc,
            ent.isCompleted,
            ent.isStarred,
            LocalDateTime.parse(ent.taskUpdated),
        )
    }

    fun subtaskIntoEnt(subtask: Subtask): SubtaskEnt {
        return SubtaskEnt(
            subtask.subtaskDetails,
            subtask.taskId,
            subtask.subtaskId,
            subtask.isCompleted,
        )
    }

    fun subtaskFromEnt(ent: SubtaskEnt): Subtask {
        return Subtask(
            ent.subtaskDetails,
            ent.taskId,
            ent.subtaskId,
            ent.isCompleted,
        )
    }
}