package com.mintokoneko.hackathonhomework.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mintokoneko.hackathonhomework.R
import com.mintokoneko.hackathonhomework.utils.CustomFragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CustomFragmentManager.setActivity(this)
    }
}