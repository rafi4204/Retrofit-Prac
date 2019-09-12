package com.example.retrofittest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofittest.CallBack
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.repository.DataRepository

class MainActivityViewModel : ViewModel(), CallBack {
    var data = MutableLiveData<List<DataModel>>()
    var repo: DataRepository? = null

    var call: CallBack? = null

    fun GetData() {
        repo = DataRepository()
        repo?.callBack = this
        //repo?.a()


        repo?.execute {
            data.postValue(it)
        }

    }

    override fun SendData(vm: List<DataModel>) {
        //data.value = vm

        data.postValue(vm)

    }
}