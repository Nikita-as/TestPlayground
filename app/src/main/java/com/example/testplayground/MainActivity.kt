package com.example.testplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.replace
import com.example.testplayground.fragments.detail.DetailFragment
import com.example.testplayground.fragments.list.ListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_containerAdd, ListFragment(), "ListFragment")
            .commit()
    }

    fun navigateToDetailFragment(userId: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_containerAdd, DetailFragment().apply {
                arguments = Bundle().apply { putInt("userId", userId) }
            }, "DetailFragment")
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.fragments.last().tag == "DetailFragment") {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_containerAdd, ListFragment())
                .commit()
        }

        if (supportFragmentManager.fragments.last().tag == "ListFragment") {
            super.onBackPressed()
        }
    }
}