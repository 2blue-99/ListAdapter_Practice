package com.example.listadapter


import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapter.databinding.ItemBinding
import java.util.*

/**
* 2022-11-07
* pureum
*/
//리사이클러뷰 어뎁터의 아이템 개수 가져오는건 list 어뎁터에서 관리를 하기때문에 필요없음
class RecyclerviewAdapter : ListAdapter<GirlFriend, RecyclerView.ViewHolder>(MyDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = MyViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is MyViewHolder){
            val data = getItem(position) as GirlFriend
            holder.bind(data)
        }
    }

    fun moveItem(fromPosition: Int, toPosition: Int){
        val newList = currentList.toMutableList()
        Collections.swap(newList, fromPosition, toPosition)
        submitList(newList)
    }

    fun removeItem(position: Int){
        val newList = currentList.toMutableList()
        newList.removeAt(position)
        submitList(newList)
    }
}