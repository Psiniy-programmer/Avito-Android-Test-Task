package com.example.avito_android_test_task.ui

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.avito_android_test_task.Interfaces.NumberItemListener
import com.example.avito_android_test_task.R
import com.example.avito_android_test_task.adapters.ListOfNumbersAdapter
import com.example.avito_android_test_task.viewmodel.ListOfNumbersViewModel

class ListOfNumbersFragment : Fragment(), NumberItemListener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mViewModel: ListOfNumbersViewModel
    private lateinit var adapter: ListOfNumbersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_of_numbers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(this)[ListOfNumbersViewModel::class.java]
        mRecyclerView = view.findViewById(R.id.fragment_recycler)
        mRecyclerView.layoutManager =
            GridLayoutManager(context, getSpanCount(), RecyclerView.VERTICAL, false)

        val listener = this as NumberItemListener

        adapter = if (mViewModel.list.value != null) {
            ListOfNumbersAdapter(mViewModel.list.value!!, listener)
        } else {
            ListOfNumbersAdapter(mutableListOf(), listener)
        }

        mViewModel.list.observe(
            viewLifecycleOwner,
            {
                Log.d("ListOfNumbersLiveData", "refresh")
                if (mRecyclerView.adapter == null) {
                    adapter.refresh(it)
                    adapter.notifyDataSetChanged()
                    mRecyclerView.adapter = adapter
                } else {
                    adapter.refresh(it)
                    adapter.notifyItemRemoved(posForDeleting)
                    adapter.notifyItemRangeChanged(0, adapter.itemCount)
                }
            }
        )
    }

    private fun getSpanCount(): Int {
        return if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            PortraitSpanCount else LandscapeSpanCount
    }

    companion object {
        const val TAG = "ListOfNumbers"
        const val PortraitSpanCount = 2
        const val LandscapeSpanCount = 4
        var posForDeleting = 0
    }

    override fun delete(position: Int) {
        mViewModel.deleteNumber(position)
        posForDeleting = position
    }
}