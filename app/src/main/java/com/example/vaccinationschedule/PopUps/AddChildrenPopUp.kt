package com.example.vaccinationschedule.PopUps

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.databinding.DataBindingUtil
import com.example.vaccinationschedule.Navigators.addChildrenNavigator
import com.example.vaccinationschedule.R
import com.example.vaccinationschedule.databinding.AddChildrenPopupBinding
import com.example.vaccinationschedule.viewModel.AddChildrenViewModel

class AddChildrenPopUp: Activity(), addChildrenNavigator {

    lateinit var binding: AddChildrenPopupBinding
    lateinit var viewModel: AddChildrenViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.add_children_popup);
        binding = DataBindingUtil.setContentView(this, R.layout.add_children_popup)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        window.setLayout((width * .8).toInt(), (height * .5).toInt())

        viewModel = AddChildrenViewModel(this)
        binding.addChildrenVM = viewModel
    }

    override fun onNameCorrect() {
        binding.searchName.isErrorEnabled = false
    }

    override fun onNameWrong() {
        binding.searchSurName.setError("")
    }

    override fun onSurnameCorrect() {
        binding.searchSurName.isErrorEnabled = false
    }

    override fun onSurnameWrong() {
        binding.searchSurName.setError("")
    }

    override fun onDateCorrect() {
        binding.SearchBirthDate.isErrorEnabled = false
    }

    override fun onDateWrong() {
        binding.searchSurName.setError("")
    }
}