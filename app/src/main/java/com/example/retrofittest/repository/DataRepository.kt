package com.example.retrofittest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofittest.ApiService
import com.example.retrofittest.model.DataModel
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataRepository {

    var data: MutableLiveData<List<DataModel>>? = null


    fun GetData(): MutableLiveData<List<DataModel>> {
        var retrofit =
            Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(
                GsonConverterFactory.create()
            ).build()


        var api: ApiService = retrofit.create(ApiService::class.java)
       // data = api.requestForData()
       data.value= api.requestForData().enqueue(object:Callback<MutableLiveData<List<DataModel>>>(){

       })
    }

}