package com.example.vaccinationschedule.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vaccinationschedule.Navigators.registerNavigator
import com.example.vaccinationschedule.R
import com.example.vaccinationschedule.databinding.ActivityRegisterBinding
import com.example.vaccinationschedule.viewModel.RegisterViewModel

class RegisterActivity : AppCompatActivity(),registerNavigator {
    override fun openLoginActivity() {
        var int = Intent(this, LoginActivity::class.java)
        startActivity(int)
    }

    lateinit var binding: ActivityRegisterBinding
    lateinit var registerViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        registerViewModel = RegisterViewModel(this,this)
        binding.registerVm = registerViewModel
    }
}
