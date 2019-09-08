package com.example.retrofittest

import retrofit2.Call
import retrofit2.http.GET

import retrofit2.http.POST

interface ApiService {
 @GET("/posts")
 fun requestForData():Call<List<DataModel>>

}