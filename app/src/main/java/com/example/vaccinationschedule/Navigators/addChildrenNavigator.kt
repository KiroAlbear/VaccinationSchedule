package com.example.vaccinationschedule.Navigators

interface addChildrenNavigator {

    fun onNameCorrect()
    fun onNameWrong()

    fun onSurnameCorrect()
    fun onSurnameWrong()

    fun onDateCorrect()
    fun onDateWrong()

    fun closeThisActivity()

}