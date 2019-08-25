package com.example.powerofwords2.Navigators

import com.example.vaccinationschedule.Model.CurrentUserEntity
import com.google.firebase.auth.FirebaseUser

interface FireBaseNavigator {

    fun onSuccessAdingUserData(email:String)
    fun onFailedAdingUserData()
    fun onSuccessRegisterUser()
    fun onFailRegisterUser(exception:String)
    fun onSuccessSignInUser()
    fun onFailSignInUser()
    fun onFailSignInUserWithGmail()
    fun onGettingUserByEmail(currentUser: CurrentUserEntity)
    fun onUserNotFound()


}