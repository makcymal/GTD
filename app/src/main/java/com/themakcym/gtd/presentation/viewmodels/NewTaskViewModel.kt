package com.themakcym.gtd.presentation.viewmodels

import androidx.lifecycle.*


class NewTaskViewModel : ViewModel() {
    val title_desc = MutableLiveData<Pair<String, String>>()
}