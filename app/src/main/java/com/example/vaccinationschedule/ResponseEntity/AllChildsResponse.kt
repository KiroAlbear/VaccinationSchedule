package com.example.vaccinationschedule.ResponseEntity

import com.example.vaccinationschedule.Model.ChildEntity

data class AllChildsResponse(
   var array: Array<ChildResponseEntity>
)