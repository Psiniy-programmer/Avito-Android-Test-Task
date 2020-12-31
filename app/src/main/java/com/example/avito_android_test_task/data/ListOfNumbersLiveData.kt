package com.example.avito_android_test_task.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.avito_android_test_task.Interfaces.ListOfNumberInterface
import com.example.avito_android_test_task.data.model.ListOfNumbersModel

class ListOfNumbersLiveData : MutableLiveData<MutableList<ListOfNumbersModel>>(),
    ListOfNumberInterface {

    init {
        value = mutableListOf()
        value?.add(ListOfNumbersModel("1"))
        value?.add(ListOfNumbersModel("1"))
        value?.add(ListOfNumbersModel("1"))
        value?.add(ListOfNumbersModel("1"))
        Log.d(TAG, value.toString())
    }

    override fun addNumber() {
        value?.add(ListOfNumbersModel("2"))
    }

    override fun deleteNumber() {
        value?.removeAt(0)
    }

    companion object {
        const val TAG = "ListOfNumbersLiveData"
    }
}