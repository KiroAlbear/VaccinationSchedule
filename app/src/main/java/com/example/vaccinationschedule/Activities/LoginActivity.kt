package com.example.vaccinationschedule.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vaccinationschedule.Navigators.loginNavigator
import com.example.vaccinationschedule.R
import com.example.vaccinationschedule.databinding.ActivityLoginBinding
import com.example.vaccinationschedule.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity(),loginNavigator {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    override fun openRegisterActivity() {
        var int = Intent(this, RegisterActivity::class.java)
        startActivity(int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = LoginViewModel(this, this)
        binding.loginVM = viewModel
    }
}
