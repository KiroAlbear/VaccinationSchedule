package com.example.vaccinationschedule.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.databinding.DataBindingUtil
import com.example.vaccinationschedule.Model.ChildEntity
import com.example.vaccinationschedule.PopUps.pop
import com.example.vaccinationschedule.R
import com.example.vaccinationschedule.databinding.ActivityHomeBinding
import com.example.vaccinationschedule.recycleView.childAdapter

class HomeActivity : AppCompatActivity() {
    lateinit var adapter: childAdapter
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        var childList: MutableList<ChildEntity> = mutableListOf()

        childList.add(ChildEntity("kirolos", "albear", "12-9-2019"))
        childList.add(ChildEntity("sa3eed", "albear", "13-9-2019"))
        childList.add(ChildEntity("heba", "albear", "14-9-2019"))
        adapter = childAdapter(this, childList)
        binding.shimmerRecyclerView.adapter = adapter
        binding.homeAddButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, pop::class.java))
        }
    }

}
