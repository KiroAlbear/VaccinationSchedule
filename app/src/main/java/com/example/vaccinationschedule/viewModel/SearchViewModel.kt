package com.example.vaccinationschedule.viewModel

import com.example.vaccinationschedule.Navigators.homeNavigator
import com.example.vaccinationschedule.Navigators.searchNavigator

class SearchViewModel(navigator: searchNavigator) {
    var nav = navigator
    var searchText = ""
    fun onSearfchClick() {
        nav.onSearchClick(searchText)
    }
}