package com.themakcym.gtd.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.themakcym.gtd.R
import com.themakcym.gtd.domain.useCases.*


class RecyclerFragment(private val groupId: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.recycler_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val adapter = TaskListAdapter(view.context)

        val taskList = SelectTasksByGroup().execute(groupId)
        adapter.submitList(taskList)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(view.context)
    }
}