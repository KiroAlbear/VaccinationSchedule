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
import com.example.vaccinationschedule.ResponseEntity.ChildResponseEntity
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



        getAllChilds()
        //binding.shimmerRecyclerView.adapter = adapter
        binding.homeAddButton.setOnClickListener {

            startActivity(Intent(this@HomeActivity, AddChildrenPopUp::class.java))
        }

        binding.homeSearchButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, SearchPopUp::class.java))
        }
        binding.homeLogOutButton.setOnClickListener {
            startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
            globalStrings.Parent_ID = ""
            globalStrings.Parent_Name = ""
            finish()

        }
    }

    private fun getAllChilds() {
        RetrofitClient.getInstance().create<userInterface>().getAllChilds(globalStrings.Parent_ID, globalStrings.apiKey)
            .enqueue(object :
                Callback<ArrayList<AllChildsResponse>> {
                override fun onFailure(call: Call<ArrayList<AllChildsResponse>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ArrayList<AllChildsResponse>>,
                    response: Response<ArrayList<AllChildsResponse>>
                ) {
                    if ((response.body() as ArrayList<*>).count() > 0) {
                        for (i in (response.body() as ArrayList<AllChildsResponse>)) {
                            childList.add(ChildEntity(i.name, globalStrings.Parent_Name, i.date))
                        }
                        adapter = childAdapter(HomeActivity.binding.root.context, childList)
                        binding.shimmerRecyclerView.adapter = adapter
                    }
                }


            })
    }

    private fun search() {

    }

}

