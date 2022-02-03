package com.example.retrofitdemo.repository

import android.util.Log
import com.example.countryapi.model.Cities
import com.example.countryapi.model.Countres
import com.example.retrofitdemo.api.RetrofitInstance
import com.example.retrofittest.utils.Constants.Companion.API_KEY
import com.example.retrofittest.utils.Constants.Companion.API_KEY2
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<ArrayList<Countres>> {
        return RetrofitInstance.api.getPost()
    }
 suspend fun getPostCities(cFlag:String): Response<ArrayList<Cities>> {
        //  Log.d("api key", API_KEY2)
        return RetrofitInstance.api.getPostcity(cFlag = cFlag)
    }



}