package com.example.bonflickr.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bonflickr.model.Photo
import com.example.bonflickr.model.Photos
import com.example.bonflickr.model.SearchResult
import com.example.bonflickr.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
     var  LaPhoto = MutableLiveData<Photo>()
     var  LesPhotos = MutableLiveData<Photos>()

        init {
            Repository().getPhotos(

                object : Callback<SearchResult> {
                    override fun onResponse(
                        call: Call<SearchResult>,
                        response: Response<SearchResult>
                    ) {
                        LesPhotos.value=response.body()?.photos
                        LaPhoto.value = response.body()?.photos?.photo?.get(0)
                    }

                    override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                        System.out.println("Erreur")
                    }
                }
            )
        }
        var i=0
        fun nextphoto() {

            if (i == LesPhotos.value?.photo!!.size) {
                i = 0
                LaPhoto.value=LesPhotos.value?.photo?.get(i)
            }else{
                i+=1
                LaPhoto.value= LesPhotos.value?.photo?.get(i)
            }
        }
    }
