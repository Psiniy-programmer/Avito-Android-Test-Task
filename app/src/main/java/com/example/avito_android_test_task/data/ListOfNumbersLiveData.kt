package com.example.avito_android_test_task.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.avito_android_test_task.interfaces.ListOfNumberInterface
import com.example.avito_android_test_task.data.model.ListOfNumbersModel

class ListOfNumbersLiveData : MutableLiveData<MutableList<ListOfNumbersModel>>(),
    ListOfNumberInterface {
    private val pool: MutableList<ListOfNumbersModel> = mutableListOf()

    init {
        value = Numbers.instance.numbers
    }

    class Numbers {
        val numbers: MutableList<ListOfNumbersModel> by lazy { mutableListOf() }

        object NumbersHolder {
            val instance = Numbers()
        }

        init {
            for (i in 0..NumbersCount)
                numbers.add(ListOfNumbersModel(i.toString()))
        }

        companion object {
            private const val NumbersCount = 15
            val instance: Numbers
                get() = NumbersHolder.instance
        }
    }

    override fun addNumber(): Int? {

        if (value != null) {
            val newList: MutableList<ListOfNumbersModel>? = value
            val newPos = (0..newList?.size!!).random()
            val newVal = if (pool.isEmpty())
                ListOfNumbersModel(newList.size.toString()) else pool.removeLast()
            Log.d(TAG, "$newVal")
            newList.add(newPos, newVal)
            value = newList
            return newPos
        }
        return null
    }

    override fun deleteNumber(position: Int) {
        val newList: MutableList<ListOfNumbersModel>? = value
        newList?.get(position)?.let { pool.add(it) }
        newList?.removeAt(position)
        value = newList
    }

    companion object {
        const val TAG = "ListOfNumbersLiveData"
    }
}