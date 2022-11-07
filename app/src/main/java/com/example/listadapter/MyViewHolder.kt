package com.example.listadapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapter.databinding.ItemBinding

/**
 * 2022-11-07
 * pureum
 */
class MyViewHolder(private val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data:GirlFriend){
        with(binding){
            name.text = data.name
            age.text = data.age
            height.text = data.height
            MBTI.text = data.mbti
            items.setOnClickListener {
                Log.e("TAG", "Click", )
            }
        }
    }

    fun setAlpha(alpha : Float){
        with(binding){
            name.alpha = alpha
            age.alpha = alpha
            height.alpha = alpha
            MBTI.alpha = alpha
        }
    }
}