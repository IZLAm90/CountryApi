package com.example.retrofitdemo.repository

import android.util.Log
import com.example.countryapi.model.Cities
import com.example.countryapi.model.Countres
import com.example.retrofitdemo.api.RetrofitInstance
import com.example.retrofittest.utils.Constants.Companion.API_KEY
import com.example.retrofittest.utils.Constants.Companion.API_KEY2
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Countres> {
        return RetrofitInstance.api.getPost(API_KEY)
    }
 suspend fun getPostCities(): Response<Cities> {
     Log.d("api key", API_KEY2)
        return RetrofitInstance.api.getPostcity(API_KEY2)
    }



}