package com.example.avito_android_test_task.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avito_android_test_task.Interfaces.ListOfNumberInterface
import com.example.avito_android_test_task.data.ListOfNumbersLiveData
import com.example.avito_android_test_task.data.model.ListOfNumbersModel
import kotlinx.coroutines.launch

class ListOfNumbersViewModel : ViewModel(), ListOfNumberInterface {
    var list = ListOfNumbersLiveData()
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
    }

    override fun addNumber() {
        viewModelScope.launch {
            list.addNumber()
        }
    }

    override fun deleteNumber() {
        viewModelScope.launch {
            list.addNumber()
        }
    }
}