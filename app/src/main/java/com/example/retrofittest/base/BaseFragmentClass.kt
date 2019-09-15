package com.example.retrofittest.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.retrofittest.R

open class BaseFragmentClass: AppCompatActivity(),FragmentInterface {
    override fun setFragment(frag: Fragment, flag: Boolean) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, frag)
        fragmentTransaction.commit()
    }
}