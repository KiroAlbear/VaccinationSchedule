package com.example.vaccinationschedule.Model

import com.google.gson.annotations.SerializedName

data class CurrentUserEntity(
    @SerializedName("ALevalFormat")
    var full_email: String,
    @SerializedName("UserName")
    var e_username: String,
    @SerializedName("TLD")
    var e_tld: String,
    @SerializedName("")
    var e_punycode: String,
    @SerializedName("Language")
    var e_language: String,
    @SerializedName("DomainName")
    var e_domain: String
)
