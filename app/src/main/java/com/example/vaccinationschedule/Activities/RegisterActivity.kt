package com.example.vaccinationschedule.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.vaccinationschedule.Navigators.registerNavigator
import com.example.vaccinationschedule.R
import com.example.vaccinationschedule.databinding.ActivityRegisterBinding
import com.example.vaccinationschedule.viewModel.RegisterViewModel

class RegisterActivity : AppCompatActivity(),registerNavigator {
    override fun onUserAlreadyExist() {
        Toast.makeText(this,"user is already exist",Toast.LENGTH_SHORT).show()
    }

    override fun openHomeActivity() {
        var int = Intent(this, HomeActivity::class.java)
        startActivity(int)
    }

    override fun onEmaileCorrect() {
        binding.signInUserEmailEditeText.isErrorEnabled = false
    }

    override fun onEmaileWrong() {
        binding.signInUserEmailEditeText.setError(getString(R.string.emailErrorMessage))
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    override fun onPasswordCorrect() {
        binding.signInPasswordEditeText.isErrorEnabled = false
    }

    override fun onPasswordWrong() {
        binding.signInPasswordEditeText.setError(getString(R.string.emailErrorMessage))
    }
    /////////////////////////////////////////////////////////////////
    override fun onNameCorrect() {
        binding.signUpNameEditeText.isErrorEnabled = false
    }

    override fun onNameWrong() {
        binding.signUpNameEditeText.setError(getString(R.string.emailErrorMessage))
    }
    /////////////////////////////////////////////////////////////
    override fun onPhoneCorrect() {
        binding.phoneEditeText.isErrorEnabled = false
    }

    override fun onPhoneWrong() {
        binding.phoneEditeText.setError(getString(R.string.emailErrorMessage))
    }
    /////////////////////////////////////////////////////////////////////
    override fun onStreetCorrect() {
        binding.streetEditeText.isErrorEnabled = false
    }

    override fun onStreetWrong() {
        binding.streetEditeText.setError(getString(R.string.emailErrorMessage))
    }
    /////////////////////////////////////////////////////////////
    override fun onIDCorrect() {
        binding.idNumberEditeText.isErrorEnabled = false
    }

    override fun onIDWrong() {
        binding.idNumberEditeText.setError(getString(R.string.emailErrorMessage))
    }
///////////////////////////////////////////////////////////
    override fun onSurnameCorrect() {
        binding.surNameEditeText.isErrorEnabled = false
    }

    override fun onSurnameWrong() {
        binding.surNameEditeText.setError(getString(R.string.emailErrorMessage))
    }

    override fun onCityCorrect() {
        binding.cityEditeText.isErrorEnabled = false
    }

    override fun onCityWrong() {
        binding.cityEditeText.setError(getString(R.string.emailErrorMessage))
    }

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
