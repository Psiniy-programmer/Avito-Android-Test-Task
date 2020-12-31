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
        value?.add(ListOfNumbersModel("2"))
        value?.add(ListOfNumbersModel("3"))
        value?.add(ListOfNumbersModel("4"))
        value?.add(ListOfNumbersModel("5"))
        value?.add(ListOfNumbersModel("6"))
        value?.add(ListOfNumbersModel("7"))
        Log.d(TAG, value.toString())
    }

    override fun addNumber() {
        value?.add(ListOfNumbersModel("2"))
    }

    override fun deleteNumber(position: Int) {
        Log.d(TAG, "inncome pos = ${position.toString()}")
        value?.get(position)?.let { Log.d(TAG, "val on income pos = ${it.toString()}") }
        Log.d(TAG, "BEFORE LIST = $value")
        val newList: MutableList<ListOfNumbersModel>? = value
        newList?.removeAt(position)
        Log.d(TAG, "AFTER LIST = $value")
        value = newList
        Log.d(TAG, value?.size.toString())
    }

    companion object {
        const val TAG = "ListOfNumbersLiveData"
    }
}