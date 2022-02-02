package com.example.retrofitdemo.api

import com.example.countryapi.model.Cities
import com.example.countryapi.model.Countres
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @GET("countries")
    suspend fun getPost(@Query("X-CSCAPI-KEY") api_key:String ): Response<Countres>

    @GET("v1/countries/EG/cities")
    suspend fun getPostcity(@Query("X-CSCAPI-KEY") api_key:String):Response<Cities>


}