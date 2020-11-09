package com.example.bonflickr.repository


import com.example.bonflickr.model.SearchResult
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrAPI {
    @GET("/services/rest?format=json&nojsoncallback=1")
    fun getInterestingPhotos(
        @Query("method") method : String,
        @Query("api_key") key: String,
        @Query("per_page") perpage: String
    ) : Call<SearchResult>
}