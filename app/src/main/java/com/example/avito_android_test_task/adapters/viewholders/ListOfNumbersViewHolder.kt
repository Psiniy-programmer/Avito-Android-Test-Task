package com.example.avito_android_test_task.adapters.viewholders

import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.avito_android_test_task.R

class ListOfNumbersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var mText: TextView = view.findViewById(R.id.number_text)
        private set
    var mLayout: RelativeLayout = view.findViewById(R.id.number_layout)
        private set
}