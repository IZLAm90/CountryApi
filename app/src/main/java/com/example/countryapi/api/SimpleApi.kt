package com.example.retrofitdemo.api

import com.example.countryapi.model.Cities
import com.example.countryapi.model.Countres
import retrofit2.Response
import retrofit2.http.*

interface SimpleApi {

    @Headers("X-CSCAPI-KEY: RU5uaVpqekRZZlBsVkhRY2ZSTzJNOHNzSGk3U3BpRmdURmpRZ2ZNMA==")
    @GET("v1/countries")
    suspend fun getPost(): Response<ArrayList<Countres>>

    @Headers("X-CSCAPI-KEY: RU5uaVpqekRZZlBsVkhRY2ZSTzJNOHNzSGk3U3BpRmdURmpRZ2ZNMA==")
    @GET("v1/countries/{ISO2}/cities")
    suspend fun getPostcity(@Path("ISO2") cFlag:String):Response<ArrayList<Cities>>


}