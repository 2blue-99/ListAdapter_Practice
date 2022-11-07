package com.example.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val dataSet = arrayListOf<GirlFriend>().apply {
        add(GirlFriend("이푸름",24,170,"ENFP"))
        add(GirlFriend("김푸름",24,170,"ENFP"))
        add(GirlFriend("박푸름",24,170,"ENFP"))
        add(GirlFriend("유푸름",24,170,"ENFP"))
        add(GirlFriend("정푸름",24,170,"ENFP"))
        add(GirlFriend("장푸름",24,170,"ENFP"))
        add(GirlFriend("독고푸름",24,170,"ENFP"))
        add(GirlFriend("하푸름",24,170,"ENFP"))
        add(GirlFriend("공푸름",24,170,"ENFP"))
        add(GirlFriend("굥푸름",24,170,"ENFP"))
        add(GirlFriend("앙푸름",24,170,"ENFP"))
        add(GirlFriend("밈푸름",24,170,"ENFP"))
        add(GirlFriend("뿡푸름",24,170,"ENFP"))
    }

    private val myRecyclerViewAdapter : RecyclerviewAdapter by lazy {
        RecyclerviewAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        binding.recycler.adapter = myRecyclerViewAdapter
        myRecyclerViewAdapter.submitList(dataSet)

        val itemTouchHelperCallback = ItemTouchHelper(MyItemTouchHelperCallback(binding.recycler))
        itemTouchHelperCallback.attachToRecyclerView(binding.recycler)

        binding.shuffle.setOnClickListener{
            myRecyclerViewAdapter.submitList(dataSet.shuffled())
        }
    }
}