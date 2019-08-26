package com.example.vaccinationschedule.viewModel

import android.content.Context
import com.example.vaccinationschedule.BasicFunctions.UserHelper
import com.example.vaccinationschedule.FireBaseFunctions.FireBaseFunctions
import com.example.vaccinationschedule.Navigators.loginNavigator
import com.example.vaccinationschedule.viewModelHelper

class LoginViewModel(navigator: loginNavigator, context: Context) : viewModelHelper() {
    var loginEmail: String = ""
    var loginPassword: String = ""
    var navigator = navigator
    private var userHelper: UserHelper = UserHelper()
    private var fireBaseFunctions = FireBaseFunctions(this, context)
    fun onSignInClick() {
        loginEmail = loginEmail.trim()

        val validatePassword = userHelper.validateUserPassword(loginPassword)
        val validateEmail = userHelper.validateUserEmail(loginEmail)


        if (!validateEmail)
            navigator.onEmaileWrong()
        else
            navigator.onEmaileCorrect()
////////////////////////////////////////
        if (!validatePassword)
            navigator.onPasswordWrong()
        else
            navigator.onPasswordCorrect()
///////////////////////////////////////////////////////////

        if(validateEmail&&validatePassword)
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