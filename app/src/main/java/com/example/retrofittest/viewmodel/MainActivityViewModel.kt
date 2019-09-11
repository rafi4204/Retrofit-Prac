package com.example.retrofittest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofittest.model.DataModel
import com.example.retrofittest.repository.DataRepository

class MainActivityViewModel : ViewModel() {

    var data: MutableLiveData<List<DataModel>>? = null

      var dRepo=DataRepository()

    fun GetData():MutableLiveData<List<DataModel>>{
        data=dRepo.GetData()
        return dRepo.GetData()
    }
}