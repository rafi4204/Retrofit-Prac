package com.example.retrofittest

import androidx.lifecycle.MutableLiveData
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.viewmodel.MainActivityViewModel

interface CallBack {
    fun SendData(vm: List<DataModel>)
}