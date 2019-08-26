package com.example.vaccinationschedule.viewModel

import android.content.Context
import com.example.vaccinationschedule.FireBaseFunctions.FireBaseFunctions
import com.example.vaccinationschedule.Navigators.loginNavigator
import com.example.vaccinationschedule.viewModelHelper

class LoginViewModel(navigator: loginNavigator, context: Context) : viewModelHelper() {
    var loginEmail: String = ""
    var loginPassword: String = ""
    var navigator = navigator
    private var fireBaseFunctions = FireBaseFunctions(this, context)
    fun onSignInClick() {
        loginEmail = loginEmail.trim()
        fireBaseFunctions.signInUser(loginEmail, loginPassword)
    }

    fun onCreateAccountClick() {
        navigator.openRegisterActivity()
    }


    override fun onFailSignInUser() {

    }

    override fun onSuccessSignInUser() {
        navigator.openHomeActivity()
    }
}