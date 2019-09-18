package com.example.retrofittest

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofittest.base.BaseFragmentClass
import com.example.retrofittest.utils.AppHelper
import kotlinx.android.synthetic.main.fragment_blank.*




class BlankFragment : BaseFragmentClass() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userId.text=arguments?.getInt(AppHelper.USERID,-1).toString()
        body.text= arguments?.getString(AppHelper.BODY,"")
        Id.text=arguments?.getInt(AppHelper.ID,-1).toString()
        title.text=arguments?.getString(AppHelper.TITLE,"")
        setNotifuication(arguments!!.getString(AppHelper.TITLE,""), arguments!!.getString(AppHelper.BODY,""),"BlankFragmentClass")

    }

}
