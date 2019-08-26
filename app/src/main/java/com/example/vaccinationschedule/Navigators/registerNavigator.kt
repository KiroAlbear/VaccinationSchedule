package com.example.vaccinationschedule.Navigators

interface registerNavigator {
    fun openLoginActivity()

    fun onEmaileCorrect()
    fun onEmaileWrong()

    fun onPasswordCorrect()
    fun onPasswordWrong()

    fun onNameCorrect()
    fun onNameWrong()

    fun onPhoneCorrect()
    fun onPhoneWrong()

    fun onStreetCorrect()
    fun onStreetWrong()

    fun onIDCorrect()
    fun onIDWrong()

    fun onSurnameCorrect()
    fun onSurnameWrong()


    fun onCityCorrect()
    fun onCityWrong()

}