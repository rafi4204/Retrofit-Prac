package com.example.retrofittest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofittest.model.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
 @GET("/posts")
 fun requestForData(): Call<MutableLiveData<List<DataModel>>>

}