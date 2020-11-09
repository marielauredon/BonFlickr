package com.example.bonflickr.ui.liste

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bonflickr.model.Photo
import com.example.bonflickr.model.Photos
import com.example.bonflickr.model.SearchResult
import com.example.bonflickr.repository.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var  LesPhotos = MutableLiveData<List<Photo>>()
    init {
        Repository().getPhotos(

            object : Callback<SearchResult> {
                override fun onResponse(
                    call: Call<SearchResult>,
                    response: Response<SearchResult>
                ) {
                    LesPhotos.value=response.body()?.photos?.photo

                }

                override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                    System.out.println("Erreur")
                }
            }
        )
    }
}