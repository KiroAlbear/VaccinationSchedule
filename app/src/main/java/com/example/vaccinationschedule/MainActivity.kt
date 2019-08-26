package com.example.vaccinationschedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.powerofwords2.Navigators.FireBaseNavigator
import com.example.vaccinationschedule.FireBaseFunctions.FireBaseFunctions
import com.example.vaccinationschedule.Model.ChildEntity
import com.example.vaccinationschedule.Model.CurrentUserEntity
import com.example.vaccinationschedule.retrofitInterface.RetrofitClient
import com.example.vaccinationschedule.retrofitInterface.userInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

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
        var childList:ArrayList<ChildEntity> = arrayListOf()

        childList.add(ChildEntity("kevin","kirolos","20-9-1990"))
        childList.add(ChildEntity("agnes","kirolos","20-9-1990"))
        childList.add(ChildEntity("helana","kirolos","20-9-1990"))

        val fire: FireBaseFunctions = FireBaseFunctions(this,this)


//        fire.addUser(CurrentUserEntity("kirolos@gmail.com","kirolos",
//                                     "com","xs","english","gmail"),childList)

        //fire.getChildrenByEmail("kirolos@gmail.com")








       // fire.getUsreByProperty()
    }
}
