package com.example.vaccinationschedule.viewModel

import android.content.Context
import com.example.vaccinationschedule.FireBaseFunctions.FireBaseFunctions
import com.example.vaccinationschedule.Model.ParentEntity
import com.example.vaccinationschedule.Navigators.registerNavigator
import com.example.vaccinationschedule.viewModelHelper

class RegisterViewModel(navigator: registerNavigator,context: Context) : viewModelHelper() {
    var name: String = ""
    var surname: String = ""
    var password: String = ""
    var idNumber: String = ""
    var Street: String = ""
    var City: String = ""
    var emailAddress: String = ""
    var mobilePhone: String = ""
    var navigator = navigator
    private var firebaseFunctions: FireBaseFunctions

    init {
        firebaseFunctions = FireBaseFunctions(this, context)
    }

    fun getParetn(): ParentEntity {
        return ParentEntity(name, surname, password, idNumber, Street, City, emailAddress, mobilePhone)
    }

    fun onSignUpClick() {
        //trime data
        trimData()

        firebaseFunctions.signUpUser(emailAddress, password)
    }

    fun trimData() {
        name = name.trim()
        surname = surname.trim()
        idNumber = idNumber.trim()
        Street = Street.trim()
        City = City.trim()
        emailAddress = emailAddress.trim()
        mobilePhone = mobilePhone.trim()
    }

    fun onSignInClick(){
        navigator.openLoginActivity()
    }

    override fun onSuccessRegisterUser() {

    }
}