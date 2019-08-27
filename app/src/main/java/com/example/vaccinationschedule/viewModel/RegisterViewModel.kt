package com.example.vaccinationschedule.viewModel

import android.content.Context
import com.example.vaccinationschedule.BasicFunctions.UserHelper
import com.example.vaccinationschedule.BasicFunctions.globalStrings
import com.example.vaccinationschedule.FireBaseFunctions.FireBaseFunctions
import com.example.vaccinationschedule.Model.ParentEntity
import com.example.vaccinationschedule.Navigators.registerNavigator
import com.example.vaccinationschedule.retrofitInterface.RetrofitClient
import com.example.vaccinationschedule.retrofitInterface.userInterface
import com.example.vaccinationschedule.viewModelHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

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
//
//        val validatePassword = userHelper.validateUserPassword(password)
//        val validateEmail = userHelper.validateUserEmail(emailAddress)
//        val validateName = true
//        val validateSurname = true
//
//        val validateStreet = true
//        val validateCity = true
//        val validatePhone = userHelper.validatePhone(mobilePhone)

//        if (!validateEmail)
//            navigator.onEmaileWrong()
//        else
//            navigator.onEmaileCorrect()
////////////////////////////////////////
//        if (!validatePassword)
//            navigator.onPasswordWrong()
//        else
//            navigator.onPasswordCorrect()
///////////////////////////////////////////////////////////

//        if (!validateName)
//            navigator.onNameWrong()
//        else
//            navigator.onNameCorrect()

/////////////////////////////////////////////////////////
//        if (!validateSurname)
//            navigator.onSurnameWrong()
//        else
//            navigator.onSurnameCorrect()
/////////////////////////////////////////////////////////

//        if (!validateID)
//            navigator.onIDWrong()
//        else
//            navigator.onIDCorrect()
//////////////////////////////////////////////////////////

//        if (!validateStreet)
//            navigator.onStreetWrong()
//        else
//            navigator.onStreetCorrect()

//////////////////////////////////////////////////////////

//        if (!validateCity)
//            navigator.onCityWrong()
//        else
//            navigator.onCityCorrect()
///////////////////////////////////////////////////////
//        if (!validatePhone)
//            navigator.onPhoneWrong()
//        else
//            navigator.onPhoneCorrect()

         //if (validatePassword && validateEmail && validateName && validateSurname && validateStreet && validateCity && validatePhone)
              signUpUser()
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

    fun signUpUser() {
//        name = "kirollos"
//        surname = "albear"
//        Street = "teraa st"
//        City = "shoubra"
//        mobilePhone = "01272911668"
//        idNumber = "1245567895456545"
//        password = "kiro12345"
//        emailAddress = "kirolos.albear21@gmail.com"
        RetrofitClient.getInstance().create<userInterface>().addParent(
            name, surname, Street,
            City, mobilePhone, idNumber, emailAddress, password
        ).enqueue(object :
            Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                navigator.onUserAlreadyExist()
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.body() != globalStrings.signupErrorMessage)
                {
                    globalStrings.Parent_ID = response.body().toString()
                    navigator.openHomeActivity()
                }

                else
                    navigator.onUserAlreadyExist()
            }

        })
    }


}