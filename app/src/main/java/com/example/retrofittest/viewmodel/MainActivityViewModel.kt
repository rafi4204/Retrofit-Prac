package com.example.retrofittest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofittest.CallBack
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.repository.DataRepository

class MainActivityViewModel : ViewModel() ,CallBack{
    override fun SendData(vm: List<DataModel>) {
             data.value=vm
    }


    var data = MutableLiveData<List<DataModel>>()
    var repo: DataRepository? = null

    var call: CallBack? = null

//    fun GetData(): MutableLiveData<List<DataModel>>? {
//        data = dRepo.GetData()
//        if(data==null)
//        {
//            Thread.sleep(5000)
//        }
//            return data
//
//    }


    fun SetCallBack(call: CallBack) {
        this.call = call
    }

    fun GetData() {
        repo = DataRepository()
        repo?.callBack=this
        repo?.a()


    }
}