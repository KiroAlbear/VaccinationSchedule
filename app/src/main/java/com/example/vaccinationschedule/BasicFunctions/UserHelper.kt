package com.example.vaccinationschedule.BasicFunctions


open class UserHelper {

    fun validateUserEmail(email: String): Boolean {
        var reg = Regex("(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
        return reg.matches(email)
    }

    fun validateCharactersOnly(string: String): Boolean {
        var reg = Regex("[a-zA-Z ]+")
        return reg.matches(string)
    }

    fun validateID(string: String): Boolean {

        return string.length == 16
    }

    fun validatePhone(phone: String): Boolean {
        return phone.length == 11
    }

    fun validateUserPassword(password: String): Boolean {
        var reg = Regex("^(?=.*[0-9])(?=.*[a-z]).{8,}\$")
        return reg.matches(password)
    }
}