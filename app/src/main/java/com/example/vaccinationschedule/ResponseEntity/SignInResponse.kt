package com.example.vaccinationschedule.ResponseEntity

data class SignInResponse(
    var ParentId:String,
    var FirstName: String,
    var LastName: String,
    var Address: String,
    var City: String,
    var Phone: String,
    var NationalId: String,
    var Password: String
)