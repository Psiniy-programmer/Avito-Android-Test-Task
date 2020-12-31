package com.example.avito_android_test_task.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avito_android_test_task.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentByTag(ListOfNumbersFragment.TAG) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, ListOfNumbersFragment())
                    .commit()
        }
    }
}