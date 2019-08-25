package com.example.vaccinationschedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.powerofwords2.BasicFunctions.FireBaseFunctions
import com.example.powerofwords2.Navigators.FireBaseNavigator
import com.example.vaccinationschedule.Model.CurrentUserEntity

class MainActivity : AppCompatActivity(),FireBaseNavigator {
    override fun onSuccessAdingUserData(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fire:FireBaseFunctions = FireBaseFunctions(this,this)
//        fire.insertUser(CurrentUserEntity("kirolos@gmail.com","kirolos",
//                                     "com","xs","english","gmail"))
       // fire.getUsreByProperty()
    }
}
