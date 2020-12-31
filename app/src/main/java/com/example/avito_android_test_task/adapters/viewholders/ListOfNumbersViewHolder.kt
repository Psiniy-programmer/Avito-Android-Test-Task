package com.example.avito_android_test_task.adapters.viewholders

import android.view.View
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.avito_android_test_task.R

class ListOfNumbersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var mText: TextView = view.findViewById(R.id.number_text)
        private set
    var mButton: ImageButton = view.findViewById(R.id.number_delete_button)
        private set
}