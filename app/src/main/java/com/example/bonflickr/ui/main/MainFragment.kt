package com.example.bonflickr.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.bonflickr.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var imageview: ImageView
    private lateinit var allimages: Button
    private lateinit var next: Button
    private lateinit var titre: TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        var view = inflater.inflate(R.layout.main_fragment, container, false)
        next = view.findViewById<Button>(R.id.next)
        allimages=view.findViewById<Button>(R.id.allImages)
        imageview = view.findViewById<ImageView>(R.id.imageView)
        titre = view.findViewById<TextView>(R.id.textView)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        var LaPhoto=viewModel.LaPhoto

        LaPhoto.observe(requireActivity(), Observer {
            val url = "https://farm" + LaPhoto.value?.farm + ".staticflickr.com/" + LaPhoto.value?.server + "/" + LaPhoto.value?.id+"_"+LaPhoto.value?.secret + ".jpg"
            Glide.with(requireActivity()).load(url).into(imageview);
            titre.setText(LaPhoto.value?.title)
        })

        next.setOnClickListener() {
            viewModel.nextphoto()
        }

        allimages.setOnClickListener() {
            Navigation.findNavController(allimages).navigate(R.id.versListeFragment)
        }

        imageview.setOnClickListener(){
           val action = MainFragmentDirections.agrandir("https://farm" + LaPhoto.value?.farm + ".staticflickr.com/" + LaPhoto.value?.server + "/" + LaPhoto.value?.id+"_"+LaPhoto.value?.secret + ".jpg")
            Navigation.findNavController(imageview).navigate(action)
        }



        // TODO: Use the ViewModel
    }

}