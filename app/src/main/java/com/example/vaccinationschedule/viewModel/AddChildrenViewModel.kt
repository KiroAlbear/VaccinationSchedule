package com.example.vaccinationschedule.viewModel

import androidx.core.text.isDigitsOnly
import com.example.vaccinationschedule.Activities.HomeActivity
import com.example.vaccinationschedule.BasicFunctions.UserHelper
import com.example.vaccinationschedule.BasicFunctions.globalStrings
import com.example.vaccinationschedule.Model.ChildEntity
import com.example.vaccinationschedule.Navigators.addChildrenNavigator
import com.example.vaccinationschedule.recycleView.childAdapter
import com.example.vaccinationschedule.retrofitInterface.RetrofitClient
import com.example.vaccinationschedule.retrofitInterface.userInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class AddChildrenViewModel(private var navigator: addChildrenNavigator) {
    var surname = ""
    var name = ""
    var birthOfDate = ""

    private var userHelper: UserHelper = UserHelper()
    fun onSearchClick() {
        trimData()

        val validateName = userHelper.validateCharactersOnly(name)
        val validateSurname = userHelper.validateCharactersOnly(surname)
        val validateBirthDate = userHelper.validateBirthDate(birthOfDate)

        if (!validateName)
            navigator.onNameWrong()
        else
            navigator.onNameCorrect()

        //////////////////////////////////////////
        if (!validateSurname)
            navigator.onSurnameWrong()
        else
            navigator.onSurnameCorrect()
        ///////////////////////////////////////
        if (!validateBirthDate)
            navigator.onDateWrong()
        else
            navigator.onDateCorrect()

         if (validateName && validateSurname && validateBirthDate)
             addChild()



    }

    fun addChild() {
//        name = "kiro"
//        surname = "albear"
//        birthOfDate = "8/27/2019"
        RetrofitClient.getInstance().create<userInterface>().AddChild(
            globalStrings.Parent_ID, name, birthOfDate, globalStrings.apiKey

        ).enqueue(object :
            Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                navigator.closeThisActivity()
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.body().toString().isDigitsOnly()) {
                    HomeActivity.childList.add(ChildEntity(name, surname, birthOfDate))
                    HomeActivity.adapter = childAdapter(HomeActivity.binding.root.context, HomeActivity.childList)
                    HomeActivity.binding.shimmerRecyclerView.adapter = HomeActivity.adapter
                }
                navigator.closeThisActivity()
            }

        })
    }

    fun trimData() {
        surname = surname.trim()
        name = name.trim()
        birthOfDate = birthOfDate.trim()
    }
}