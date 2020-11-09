package com.example.bonflickr.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bonflickr.R
import com.example.bonflickr.model.Photo

class MyAdapter(var photos : List<Photo>?) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    class MyViewHolder(val v: LinearLayout) : RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyAdapter.MyViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.photo,parent,false)
        return MyViewHolder(layout as LinearLayout)
    }


    override fun getItemCount():Int = photos?.size!!


    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position:
                                  Int) {
        val image = holder.v.findViewById<ImageView>(R.id.photoView)
        val photo = photos?.get(position)
        val url = "https://farm" + photo?.farm + ".staticflickr.com/" + photo?.server + "/" + photo?.id+"_"+photo?.secret + ".jpg"
        Glide.with(image.context).load(url).into(image)

        image.setOnClickListener(){
            val action = MainFragmentDirections.agrandir(url)
            Navigation.findNavController(image).navigate(action)
        }
    }

}
