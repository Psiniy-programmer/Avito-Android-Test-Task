package com.example.avito_android_test_task.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avito_android_test_task.data.ListOfNumbersLiveData
import com.example.avito_android_test_task.data.model.ListOfNumbersModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListOfNumbersViewModel : ViewModel() {
    var list = ListOfNumbersLiveData()
    var newPos: Int? = null
    private var mMediatorLiveData = MediatorLiveData<MutableList<ListOfNumbersModel>>()

    init {
        mMediatorLiveData.addSource(list) {
            if (it != null) {
                viewModelScope.launch {
                    mMediatorLiveData.postValue(it)
                }
            } else {
                mMediatorLiveData.value = null
            }
        }
        addNumber()
    }

    private fun addNumber() {
        viewModelScope.launch {
           while(true) {
               newPos = list.addNumber()
               delay(1000)
           }
        }
    }

    fun deleteNumber(position: Int) {
        viewModelScope.launch {
            list.deleteNumber(position)
        }
    }
}