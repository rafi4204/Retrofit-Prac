package com.example.retrofittest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.adapter.CustomAdapter
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var adapter: CustomAdapter? = null
    var vm: MainActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        vm?.GetData()
        vm?.data?.observe(this, object : Observer<List<DataModel>> {
            /**
             * Called when the data is changed.
             * @param t  The new data
             */
            override fun onChanged(t: List<DataModel>?) {
                adapter = CustomAdapter(this@MainActivity,t)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView.adapter = adapter

            }


        })

//        adapter = CustomAdapter(this, vm?.data?.value)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = adapter

    }
}
