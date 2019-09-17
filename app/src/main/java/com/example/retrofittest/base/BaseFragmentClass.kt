package com.example.retrofittest.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.retrofittest.R

open class BaseFragmentClass: Fragment(),FragmentInterface {
    override fun addFragment(frag: Fragment, flag: Boolean) {



        val transaction = activity?.supportFragmentManager?.beginTransaction()?.apply {
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            replace(R.id.frameLayout, frag)
            addToBackStack(null)
        }


        transaction?.commit()
    }

    override fun setFragment(frag: Fragment, flag: Boolean) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.add(R.id.frameLayout, frag)
        fragmentTransaction?.commit()
    }
}