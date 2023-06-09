package com.themakcym.gtd.presentation.viewmodels

import androidx.lifecycle.*
import com.themakcym.gtd.di.Dep
import com.themakcym.gtd.domain.models.Task


class EditTaskViewModel : ViewModel() {

    private val repo = Dep.repo

    val task = MutableLiveData<Task>()
}