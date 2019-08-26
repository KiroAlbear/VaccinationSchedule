package com.example.vaccinationschedule.Navigators

interface loginNavigator {
    fun openRegisterActivity()
    fun openHomeActivity()


    fun onEmaileCorrect()
    fun onEmaileWrong()

    fun onPasswordCorrect()
    fun onPasswordWrong()
}