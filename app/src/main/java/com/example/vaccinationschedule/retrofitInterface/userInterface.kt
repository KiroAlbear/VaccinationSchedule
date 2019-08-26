package com.example.vaccinationschedule.retrofitInterface

import com.example.vaccinationschedule.Model.CurrentUserEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface userInterface {

    @GET("test2")
    fun validateEmail(@Query("email")  email:String,
                      @Query("fbclid") apiKey: String): Call<CurrentUserEntity>

    @GET("AddPerant")
    fun addParent(@Query("firstName")  firstName:String,
                  @Query("lastName")   lastName:String,
                  @Query("address")    address:String,
                  @Query("city")       city:String,
                  @Query("phone")      phone:String,
                  @Query("nationalId") nationalId:String,
                  @Query("password")   password:String): Call<String>
}