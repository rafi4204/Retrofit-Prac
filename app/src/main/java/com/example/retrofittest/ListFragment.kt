package com.example.retrofittest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.adapter.CustomAdapter
import com.example.retrofittest.base.BaseFragmentClass
import com.example.retrofittest.listener.AdapterListener
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.utils.AppHelper
import com.example.retrofittest.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : BaseFragmentClass() {

    var adapter: CustomAdapter? = null

    var vm: MainActivityViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        vm = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        vm?.GetData()
        vm?.data?.observe(this, object : Observer<List<DataModel>> {
            /**
             * Called when the data is changed.
             * @param t  The new data
             */
            override fun onChanged(t: List<DataModel>?) {
                adapter = context?.let { CustomAdapter(it, t) }
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = adapter
                adapter?.Alistener = object : AdapterListener {
                    override fun listener(pos: Int) {
                        Toast.makeText(
                            context,
                            "this is listner!!!!!!!!!!!!!!!!!!!!!!",
                            Toast.LENGTH_SHORT
                        ).show()
                        val newFragment = BlankFragment()
                        var args = Bundle()
                        args = bundleOf(
                            AppHelper.ID to t?.get(pos)?.id,
                            AppHelper.TITLE to t?.get(pos)?.title,
                            AppHelper.BODY to t?.get(pos)?.body,
                            AppHelper.USERID to t?.get(pos)?.userId
                        )
                        newFragment.arguments = args
                        addFragment(newFragment, true)
                    }
                }

            }


        })
//        vm?.GetData()


    }
}




