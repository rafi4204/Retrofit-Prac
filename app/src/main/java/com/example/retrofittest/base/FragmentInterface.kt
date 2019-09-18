package com.example.retrofittest.base

import androidx.fragment.app.Fragment

interface FragmentInterface {
    fun setNotifuication(title:String,body:String,intent: String)
    fun setFragment(frag:Fragment,flag:Boolean)
    fun addFragment(frag:Fragment,flag:Boolean)
}