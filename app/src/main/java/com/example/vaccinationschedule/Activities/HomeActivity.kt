package com.example.vaccinationschedule.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vaccinationschedule.BasicFunctions.globalStrings.Companion.childList
import com.example.vaccinationschedule.Model.ChildEntity
import com.example.vaccinationschedule.Navigators.addChildrenNavigator
import com.example.vaccinationschedule.Navigators.homeNavigator
import com.example.vaccinationschedule.PopUps.AddChildrenPopUp
import com.example.vaccinationschedule.PopUps.SearchPopUp
import com.example.vaccinationschedule.databinding.ActivityHomeBinding
import com.example.vaccinationschedule.recycleView.childAdapter
import android.R
import android.annotation.SuppressLint
import com.example.vaccinationschedule.BasicFunctions.globalStrings
import com.example.vaccinationschedule.ResponseEntity.AllChildsResponse
import com.example.vaccinationschedule.ResponseEntity.SignInResponse
import com.example.vaccinationschedule.retrofitInterface.RetrofitClient
import com.example.vaccinationschedule.retrofitInterface.userInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class HomeActivity : AppCompatActivity() {


    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var adapter: childAdapter
        var childList: MutableList<ChildEntity> = mutableListOf()
        lateinit var binding: ActivityHomeBinding

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, com.example.vaccinationschedule.R.layout.activity_home)



//        childList.add(ChildEntity("kirolos", "albear", "12-9-2019"))
//        childList.add(ChildEntity("sa3eed", "albear", "13-9-2019"))
//        childList.add(ChildEntity("heba", "albear", "14-9-2019"))
//        adapter = childAdapter(this, childList)

        getAllChilds()
        //binding.shimmerRecyclerView.adapter = adapter
        binding.homeAddButton.setOnClickListener {

            startActivity(Intent(this@HomeActivity, AddChildrenPopUp::class.java))
        }

    }

    private fun getAllChilds(){
        RetrofitClient.getInstance().create<userInterface>().getAllChilds(globalStrings.Parent_ID,globalStrings.apiKey).enqueue(object :
            Callback<AllChildsResponse> {
            override fun onResponse(call: Call<AllChildsResponse>, response: Response<AllChildsResponse>) {

            }

            override fun onFailure(call: Call<AllChildsResponse>, t: Throwable) {

            }


        })
    }

}

