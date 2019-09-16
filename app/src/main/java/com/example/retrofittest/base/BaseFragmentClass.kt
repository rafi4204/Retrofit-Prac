package com.example.retrofittest.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.retrofittest.R

open class BaseFragmentClass: AppCompatActivity(),FragmentInterface {
    override fun addFragment(frag: Fragment, flag: Boolean) {

        /* Bundle args = Bundle()
         args.putInt(ArticleFragment.ARG_POSITION, position)
         newFragment.arguments = args*/

        val transaction = supportFragmentManager.beginTransaction()?.apply {
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            replace(R.id.frameLayout, frag)
            addToBackStack(null)
        }

// Commit the transaction
        transaction.commit()
    }

    override fun setFragment(frag: Fragment, flag: Boolean) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout, frag)
        fragmentTransaction.commit()
    }
}