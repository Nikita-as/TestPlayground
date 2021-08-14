package com.example.testplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testplayground.fragments.list.ListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_containerAdd, ListFragment())
            .commit()


    }

}