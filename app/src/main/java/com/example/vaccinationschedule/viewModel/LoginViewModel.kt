package com.example.vaccinationschedule.viewModel

import android.content.Context
import com.example.vaccinationschedule.BasicFunctions.UserHelper
import com.example.vaccinationschedule.BasicFunctions.globalStrings
import com.example.vaccinationschedule.FireBaseFunctions.FireBaseFunctions
import com.example.vaccinationschedule.Navigators.loginNavigator
import com.example.vaccinationschedule.ResponseEntity.SignInResponse
import com.example.vaccinationschedule.retrofitInterface.RetrofitClient
import com.example.vaccinationschedule.retrofitInterface.userInterface
import com.example.vaccinationschedule.viewModelHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class LoginViewModel(navigator: loginNavigator, context: Context) : viewModelHelper() {
    var loginEmail: String = ""
    var loginPassword: String = ""
    var navigator = navigator
    private var userHelper: UserHelper = UserHelper()
    fun onSignInClick() {
        loginEmail = loginEmail.trim()

//        val validatePassword = userHelper.validateUserPassword(loginPassword)
//        val validateEmail = userHelper.validateUserEmail(loginEmail)
//
//
//        if (!validateEmail)
//            navigator.onEmaileWrong()
//        else
//            navigator.onEmaileCorrect()
//////////////////////////////////////////
//        if (!validatePassword)
//            navigator.onPasswordWrong()
//        else
//            navigator.onPasswordCorrect()
///////////////////////////////////////////////////////////
        //if (validateEmail && validatePassword)
        SignIn()
    }

    fun onCreateAccountClick() {
        navigator.openRegisterActivity()
    }


    override fun onFailSignInUser() {

    }

    override fun onSuccessSignInUser() {
    }

    private fun SignIn() {
//        loginPassword = "kiro12345"
//        loginEmail = "kirolosa12@gmail.com"
       // loginEmail = "kirolos.albear15@gmail.com"
        //loginEmail = "kirolos.albear13@gmail.com"
       //loginEmail = "kirolos.albear21@gmail.com"
        RetrofitClient.getInstance().create<userInterface>().signIn(
            loginEmail, loginPassword, globalStrings.apiKey

        ).enqueue(object :
            Callback<SignInResponse> {
            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                navigator.onUserDoesNotExist()
            }

            override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                if(response.body()!=null){
                globalStrings.Parent_ID = response.body()!!.ParentId
                globalStrings.Parent_Name = response.body()!!.LastName
                navigator.openHomeActivity()
                }
            }

        })
    }
}