package com.example.avito_android_test_task.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.avito_android_test_task.R
import com.example.avito_android_test_task.adapters.viewholders.ListOfNumbersViewHolder
import com.example.avito_android_test_task.data.model.ListOfNumbersModel
import com.example.avito_android_test_task.Interfaces.NumberItemListener

class ListOfNumbersAdapter(
    private var mData: MutableList<ListOfNumbersModel>,
    private var listener: NumberItemListener
) : RecyclerView.Adapter<ListOfNumbersViewHolder>() {
    var newItemPos: Int? = null
    var removePos: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfNumbersViewHolder {
        return ListOfNumbersViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.number_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListOfNumbersViewHolder, position: Int) {
        Log.d("ListOfNumbersLiveData", "new POS = $position")
        newItemPos = position
        val model = mData[position]
        holder.mLayout.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.item_animation)
        holder.mText.text = model.number
        holder.mButton.setOnClickListener {
            removePos = position
            holder.mButton.isClickable = false
            listener.delete(position)
        }
    }

    fun refresh(newData: MutableList<ListOfNumbersModel>) {
        this.mData = newData
    }

    fun removeReset() {
        this.removePos = null
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}