package com.example.vaccinationschedule

import com.example.powerofwords2.Navigators.FireBaseNavigator
import com.example.vaccinationschedule.Model.CurrentUserEntity

open class viewModelHelper:FireBaseNavigator {
    override fun onFailedAdingUserData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccessRegisterUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailRegisterUser(exception: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccessSignInUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailSignInUser() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailSignInUserWithGmail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGettingUserByEmail(currentUser: CurrentUserEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onUserNotFound() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccessAdingUserData(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}