package com.example.retrofittest.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofittest.ApiService
import com.example.retrofittest.CallBack
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.viewmodel.MainActivityViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataRepository {
    var send: MainActivityViewModel? = null
    var data: MutableLiveData<List<DataModel>>? = null
    var callBack: CallBack? = null


//    fun GetData(): MutableLiveData<List<DataModel>>? {
//        var retrofit =
//            Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(
//                GsonConverterFactory.create()
//            ).build()
//
//
//        var api: ApiService = retrofit.create(ApiService::class.java)
//        // data = api.requestForData()
//        api.requestForData().enqueue(object : Callback<MutableLiveData<List<DataModel>>> {
//            /**
//             * Invoked when a network exception occurred talking to the server or when an unexpected
//             * exception occurred creating the request or processing the response.
//             */
//            override fun onFailure(callBack: Call<MutableLiveData<List<DataModel>>>, t: Throwable) {
//
//            }
//
//            /**
//             * Invoked for a received HTTP response.
//             *
//             *
//             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
//             * Call [Response.isSuccessful] to determine if the response indicates success.
//             */
//            override fun onResponse(
//                callBack: Call<MutableLiveData<List<DataModel>>>,
//                response: Response<MutableLiveData<List<DataModel>>>
//            ) {
//                data?.setValue(response.body()?.value)
//            }
//
//        })
//
//        return data
//    }

    fun a() {
        var retrofit =
            Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(
                GsonConverterFactory.create()
            ).build()


        var api: ApiService = retrofit.create(ApiService::class.java)
        // data = api.requestForData()
        api.requestForData().enqueue(object : Callback<List<DataModel>> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {

            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {

                Log.d("2", response.body()?.get(0)?.body)
                response.body()?.let {

                    callBack?.SendData(it)
                }

            }

        })
    }


}