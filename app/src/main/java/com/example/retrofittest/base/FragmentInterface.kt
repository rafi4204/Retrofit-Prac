package com.example.retrofittest.base

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

interface FragmentInterface {
    fun setNotifuication(title:String,body:String, activity: Class<out AppCompatActivity >)
    fun setFragment(frag:Fragment,flag:Boolean)
    fun addFragment(frag:Fragment,flag:Boolean)
}