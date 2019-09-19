package com.example.retrofittest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofittest.adapter.CustomAdapter
import com.example.retrofittest.base.BaseFragmentClass
import com.example.retrofittest.listener.AdapterListener
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri
import android.util.Log
import kotlinx.android.synthetic.main.fragment_list.*


class MainActivity : AppCompatActivity() {


    var adapter: CustomAdapter? = null
    var vm: MainActivityViewModel? = null
    val CHANNEL_ID="my_channel_1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      Log.d("0","notification!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout, ListFragment()).commit()


    }




}
