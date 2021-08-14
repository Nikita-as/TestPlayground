package com.example.testplayground.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testplayground.R
import com.example.testplayground.fragments.detail.DetailFragment
import com.example.testplayground.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_list.view.*

@AndroidEntryPoint
class ListFragment : Fragment(), ListAdapter.OnUserClickListener {

    private val mUserViewModel: UserViewModel by viewModels()
    private val adapter = ListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        subscribeObservers()


    }

    private fun subscribeObservers() {
        mUserViewModel.readAllData.observe(viewLifecycleOwner) {
            adapter.setNewList(it)

        }

    }

    override fun onUserClick(position: Int) {
        val user = adapter.userList[position]
        val userId = user.userId.toString()
        val fragment = DetailFragment()
        setFragmentResult("requestKey", bundleOf("bundleKey" to userId))
    }
    private fun onChange(){
}

}

