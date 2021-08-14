package com.example.testplayground.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testplayground.R
import com.example.testplayground.model.User

class ListAdapter(val onUserClickListener: OnUserClickListener? = null) :
    RecyclerView.Adapter<ListAdapter.UserHolder>() {

    val userList = mutableListOf<User>()

    inner class UserHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                onUserClickListener?.onUserClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return UserHolder(view)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val user = userList[position]

        holder.itemView.findViewById<TextView>(R.id.user_Id).text = user.userId.toString()
        holder.itemView.findViewById<TextView>(R.id.user_Name).text = user.userName
        holder.itemView.findViewById<TextView>(R.id.user_Username).text = user.userUserName

    }

    fun setNewList(newList: List<User>) {
        userList.clear()
        userList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    interface OnUserClickListener {


        fun onUserClick(position: Int)
    }
}