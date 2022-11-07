package com.example.listadapter

import androidx.recyclerview.widget.DiffUtil

/**
 * 2022-11-07
 * pureum
 */
class MyDiffCallback : DiffUtil.ItemCallback<GirlFriend>(){
    override fun areItemsTheSame(oldItem: GirlFriend, newItem: GirlFriend): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: GirlFriend, newItem: GirlFriend): Boolean {
        return oldItem == newItem
    }

}