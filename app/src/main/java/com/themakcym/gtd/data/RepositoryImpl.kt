package com.themakcym.gtd.data

import com.themakcym.gtd.domain.Repository


class RepositoryImpl(
    private val taskDao: TaskDao,
    private val groupDao: GroupDao,
    private val tagDao: TagDao
) : Repository {
//    private var tagList = mutableListOf(
//        Tag(0, "Starred"),
//        Tag(1, "Work"),
//        Tag(2, "Chill")
//    }
//    private var groupList = mutableListOf(
//        Group(0, "Bucket"),
//        Group(1, "Awaited"),
//        Group(2, "Delayed")
//    )
//    private var taskList = mutableListOf(
//        Task(
//            0, "Pay for dormitory", "Until April 30",
//            false, Date(), 2, mutableListOf(0)
//        ),
//        Task(
//            1, "Solve equation", "",
//            true, Date(), 0, mutableListOf(0, 2)
//        ),
//        Task(
//            1, "Do training", "Run for fun",
//            false, Date(), 0, mutableListOf(1, 2)
//        ),
//    )

    // <<< Task

    override fun createTask(task: Task) {
        taskDao.addTask(task)
    }

    override fun retrieveTask(taskId: Int): Task {
        return taskDao.getTaskById(taskId)
    }

    override fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    override fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

    override fun selectTasksByGroup(groupId: Int): List<Task> {
        return taskDao.getTasksByGroup(groupId)
    }

    // Task >>>


    // <<< Group

    override fun createGroup(group: Group) {
        groupDao.addGroup(group)
    }

    override fun updateGroup(group: Group) {
        groupDao.updateGroup(group)
    }

    override fun deleteGroup(group: Group) {
        groupDao.deleteGroup(group)
    }

    override fun getGroupsList(): List<Group> {
        return groupDao.getGroupsList()
    }

    // Group >>>

    // <<< Tag

    override fun createTag(tag: Tag) {
        tagDao.addTag(tag)
    }

    override fun updateTag(tag: Tag) {
        tagDao.updateTag(tag)
    }

    override fun deleteTag(tag: Tag) {
        tagDao.deleteTag(tag)
    }

    override fun getTagsList(): List<Tag> {
        return tagDao.getTagList()
    }

    // Tag >>>
}