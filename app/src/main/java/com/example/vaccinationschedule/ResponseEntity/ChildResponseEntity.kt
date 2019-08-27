package com.example.vaccinationschedule.ResponseEntity

import com.example.vaccinationschedule.Model.CurrentUserEntity

data class ChildResponseEntity (
    val DateOfBirth: String,
    val Id: Int,
    val Name: String,
    val parent: CurrentUserEntity
)