package com.example.testplayground.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testplayground.R
import com.example.testplayground.viewmodel.UserDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()

    private val viewModel: UserDetailViewModel by viewModels()

    private val adapter = PostsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        val userId = args.userId
        viewModel.getUserPost(userId = userId.toInt())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        viewModel.posts.observe(viewLifecycleOwner) {
            adapter.setNewList(it)
        }
    }

}

