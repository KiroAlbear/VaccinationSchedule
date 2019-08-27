package com.example.vaccinationschedule.BasicFunctions

import com.example.vaccinationschedule.Model.ChildEntity

class globalStrings {
    companion object {
        val e_domain = "e_domain"
        val e_language = "e_language"
        val e_punycode = "e_punycode"
        val e_tld = "e_tld"
        val e_username = "e_username"
        val full_email = "full_email"
        val COLLECTION_NAME = "users"
        val CHILDS_NAME = "childs"
        val child_date_of_birth = "date_of_birth"
        val child_name = "child_name"
        val child_surname = "child_surname"

        val email_language = "language"
        val email_ALevalFormat = "ALevalFormat"
        val email_ULevalFormat = "ULevalFormat"
        val email_UserName = "UserName"
        val email_DomainName = "DomainName"
        val email_TLD = "TLD"

        var Parent_ID:String= ""
        var Parent_Name:String = ""
        var apiKey = "IwAR0IUhctybQeSp_HXPReJf_c9olPr31igJqHh6DhNwJTv8PyXK20OFDRH6w"
        val signinErrorMessage = "user does not exist"
        val signupErrorMessage = "User Exist"

        var childList: MutableList<ChildEntity> = mutableListOf()
    }

}