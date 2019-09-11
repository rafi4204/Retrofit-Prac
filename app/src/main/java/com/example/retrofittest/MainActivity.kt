package com.example.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.adapter.CustomAdapter
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var adapter:CustomAdapter?=null
var vm: MainActivityViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       vm= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        vm!!.GetData().observe(this, object: Observer<List<DataModel>>{
            /**
             * Called when the data is changed.
             * @param t  The new data
             */
            override fun onChanged(t: List<DataModel>?) {
                adapter?.notifyDataSetChanged()

            }


        })

      adapter= CustomAdapter(this,vm!!.GetData().value)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=adapter

    }
}
