package com.example.vaccinationschedule.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vaccinationschedule.Navigators.loginNavigator
import com.example.vaccinationschedule.R
import com.example.vaccinationschedule.databinding.ActivityLoginBinding
import com.example.vaccinationschedule.viewModel.LoginViewModel
import java.util.*


class LoginActivity : AppCompatActivity(),loginNavigator {
    override fun onEmaileCorrect() {
        binding.signInUserEmailEditeText.isErrorEnabled = false
    }

    override fun onEmaileWrong() {
        binding.signInUserEmailEditeText.setError(getString(R.string.emailErrorMessage))
    }

    override fun onPasswordCorrect() {
        binding.signInPasswordEditeText.isErrorEnabled = false
    }

    override fun onPasswordWrong() {
        binding.signInPasswordEditeText.setError(getString(R.string.emailErrorMessage))
    }

    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel


    override fun openHomeActivity() {
        var int = Intent(this, HomeActivity::class.java)
        startActivity(int)
    }

    override fun openRegisterActivity() {
        var int = Intent(this, RegisterActivity::class.java)
        startActivity(int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = LoginViewModel(this, this)
        binding.loginVM = viewModel
        setLocale("Arabic")

    }

    fun setLocale(lang: String) {

        var myLocale = Locale(lang)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        conf.locale = myLocale
        res.updateConfiguration(conf, dm)
        val refresh = Intent(this, LoginActivity::class.java)
        startActivity(refresh)
    }
}
