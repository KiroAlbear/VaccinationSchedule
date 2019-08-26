package com.example.vaccinationschedule.viewModel

import android.content.Context
import com.example.vaccinationschedule.BasicFunctions.UserHelper
import com.example.vaccinationschedule.FireBaseFunctions.FireBaseFunctions
import com.example.vaccinationschedule.Model.ParentEntity
import com.example.vaccinationschedule.Navigators.registerNavigator
import com.example.vaccinationschedule.viewModelHelper

class RegisterViewModel(navigator: registerNavigator, context: Context) : viewModelHelper() {
    var name: String = ""
    var surname: String = ""
    var password: String = ""
    var idNumber: String = ""
    var Street: String = ""
    var City: String = ""
    var emailAddress: String = ""
    var mobilePhone: String = ""
    var navigator = navigator
    private var userHelper: UserHelper = UserHelper()
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

        val validatePassword = userHelper.validateUserPassword(password)
        val validateEmail = userHelper.validateUserEmail(emailAddress)
        val validateName = userHelper.validateCharactersOnly(name)
        val validateSurname = userHelper.validateCharactersOnly(surname)
        val validateID = userHelper.validateID(idNumber)
        val validateStreet = userHelper.validateCharactersOnly(Street)
        val validateCity = userHelper.validateCharactersOnly(City)
        val validatePhone = userHelper.validatePhone(mobilePhone)

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

        if (!validateName)
            navigator.onNameWrong()
        else
            navigator.onNameCorrect()

/////////////////////////////////////////////////////////
        if (!validateSurname)
            navigator.onSurnameWrong()
        else
            navigator.onSurnameCorrect()
/////////////////////////////////////////////////////////

        if (!validateID)
            navigator.onIDWrong()
        else
            navigator.onIDCorrect()
//////////////////////////////////////////////////////////

        if (!validateStreet)
            navigator.onStreetWrong()
        else
            navigator.onStreetCorrect()

//////////////////////////////////////////////////////////

        if (!validateCity)
            navigator.onCityWrong()
        else
            navigator.onCityCorrect()
///////////////////////////////////////////////////////
        if (!validatePhone)
            navigator.onPhoneWrong()
        else
            navigator.onPhoneCorrect()

        if (validatePassword && validateEmail && validateName && validateSurname && validateID && validateStreet && validateCity && validatePhone)
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

    fun onSignInClick() {
        navigator.openLoginActivity()
    }

    override fun onSuccessRegisterUser() {

    }
}