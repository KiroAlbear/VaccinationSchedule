package com.example.vaccinationschedule.PopUps

import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import com.example.vaccinationschedule.R

class SearchPopUp : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.searchpopup)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels
        val height = dm.heightPixels
        window.setLayout((width * .8).toInt(), (height * .31).toInt())
    }

}