package com.example.bonflickr.ui.liste

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bonflickr.R
import com.example.bonflickr.ui.main.MyAdapter

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater.inflate(R.layout.list_fragment, container, false)
        val recycler = view?.findViewById<RecyclerView>(R.id.recyclerview)
        recycler?.layoutManager = GridLayoutManager(requireContext(), 2)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        var LesPhotos = viewModel.LesPhotos
        LesPhotos.observe(requireActivity(), Observer {
            recycler?.adapter = MyAdapter(viewModel.LesPhotos.value)
        })

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
        // TODO: Use the ViewModel




}