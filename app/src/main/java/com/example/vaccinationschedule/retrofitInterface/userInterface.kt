package com.example.vaccinationschedule.retrofitInterface

import com.example.vaccinationschedule.Model.CurrentUserEntity
import com.example.vaccinationschedule.Model.SearchEntity
import com.example.vaccinationschedule.ResponseEntity.AllChildsResponse
import com.example.vaccinationschedule.ResponseEntity.SignInResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface userInterface {

    @GET("test2")
    fun validateEmail(
        @Query("email") email: String,
        @Query("fbclid") apiKey: String
    ): Call<CurrentUserEntity>

    @GET("AddPerant")
    fun addParent(
        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String,
        @Query("address") address: String,
        @Query("city") city: String,
        @Query("phone") phone: String,
        @Query("nationalId") nationalId: String,
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<String>


    @GET("SignIn")
    fun signIn(
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("fbclid") apiKey: String

    ): Call<SignInResponse>

    @GET("AddChild")
    fun AddChild(
        @Query("p_id") p_id: String,
        @Query("Name") Name: String,
        @Query("Date") Date: String,
        @Query("fbclid") fbclid: String
    ): Call<String>


    @GET("GetChilds")
    fun getAllChilds(
        @Query("p_id") p_id: String,
        @Query("fbclid") fbclid: String
    ): Call<ArrayList<AllChildsResponse>>


    @GET("SearchEmail")
    fun search(
        @Query("domin") domin: String
    ): Call<ArrayList<SearchEntity>>


}