package com.example.bonflickr.ui.full

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.bonflickr.R

class FullFragment : Fragment() {

    companion object {
        fun newInstance() = FullFragment()
    }
    private lateinit var fullimageview: ImageView
    private lateinit var viewModel: FullViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.full_fragment, container, false)
        fullimageview = view.findViewById<ImageView>(R.id.fullimageView)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FullViewModel::class.java)
        // TODO: Use the ViewModel
        val url = FullFragmentArgs.fromBundle(arguments!!).url
        Glide.with(requireActivity()).load(url).into(fullimageview);
    }

}