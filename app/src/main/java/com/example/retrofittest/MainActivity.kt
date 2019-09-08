package com.example.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofit =
            Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(
                GsonConverterFactory.create()
            ).build()


        var api: ApiService = retrofit.create(ApiService::class.java)
        val str = api.requestForData().enqueue(object : Callback<List<DataModel>> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                Log.d("2", t.message)
            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<List<DataModel>>,response: Response<List<DataModel>>) {
              Log.d("2", response.body()?.get(0)?.body.toString())
            }


        })


    }
}
