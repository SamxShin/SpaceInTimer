package com.bignerdranch.android.redo

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bignerdranch.android.redo.data.TimeViewModel
import com.bignerdranch.android.redo.dummy.DummyContent

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_item_list.view.*


/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {
    private lateinit var mTimeViewModel: TimeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        // Recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        // UserViewModel
        mTimeViewModel = ViewModelProvider(this).get(TimeViewModel::class.java)
        mTimeViewModel.readAllData.observe(viewLifecycleOwner, Observer { time ->
            adapter.setData(time)
        })
        return view
    }
}