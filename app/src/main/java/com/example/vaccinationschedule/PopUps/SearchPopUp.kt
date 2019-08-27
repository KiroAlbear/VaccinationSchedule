package com.example.vaccinationschedule.PopUps

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.example.vaccinationschedule.Activities.HomeActivity
import com.example.vaccinationschedule.BasicFunctions.globalStrings
import com.example.vaccinationschedule.Model.ChildEntity
import com.example.vaccinationschedule.Model.SearchEntity
import com.example.vaccinationschedule.Navigators.searchNavigator
import com.example.vaccinationschedule.R
import com.example.vaccinationschedule.ResponseEntity.AllChildsResponse
import com.example.vaccinationschedule.databinding.SearchpopupBinding
import com.example.vaccinationschedule.recycleView.childAdapter
import com.example.vaccinationschedule.recycleView.searchAdapter
import com.example.vaccinationschedule.retrofitInterface.RetrofitClient
import com.example.vaccinationschedule.retrofitInterface.userInterface
import com.example.vaccinationschedule.viewModel.SearchViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class SearchPopUp : Activity(), searchNavigator {

    lateinit var binding: SearchpopupBinding
    lateinit var viewmodel: SearchViewModel
    override fun onSearchClick(tld: String) {
        RetrofitClient.getInstance().create<userInterface>().search(tld)
            .enqueue(object :
                Callback<ArrayList<SearchEntity>> {
                override fun onResponse(
                    call: Call<ArrayList<SearchEntity>>,
                    response: Response<ArrayList<SearchEntity>>
                ) {

                    HomeActivity.binding.shimmerRecyclerView.adapter =
                        searchAdapter(HomeActivity.binding.root.context, response.body() as List<SearchEntity>)
                    finish()
                }

                override fun onFailure(call: Call<ArrayList<SearchEntity>>, t: Throwable) {
                    finish()
                }


            })


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        window.setLayout((width * .8).toInt(), (height * .31).toInt())
        binding = DataBindingUtil.setContentView(this, R.layout.searchpopup)
        viewmodel = SearchViewModel(this)
        binding.searchVM = viewmodel

    }

}