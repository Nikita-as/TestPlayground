package com.example.testplayground.fragments.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testplayground.R
import com.example.testplayground.model.UserPost

class PostsListAdapter : RecyclerView.Adapter<PostsListAdapter.PostHolder>() {

    private val postsList = mutableListOf<UserPost>()

    inner class PostHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_post_view, parent, false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post = postsList[position]
        holder.itemView.findViewById<TextView>(R.id.post_Id).text = post.id.toString()
        holder.itemView.findViewById<TextView>(R.id.post_Title).text = post.title
        holder.itemView.findViewById<TextView>(R.id.post_body).text = post.body
    }

    fun setNewList(newList: List<UserPost>) {
        postsList.clear()
        postsList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return postsList.size
    }
}