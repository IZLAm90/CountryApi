package com.example.countryapi

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryapi.model.Cities
import com.example.countryapi.model.Countres

import com.example.retrofitdemo.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<ArrayList<Cities>>> = MutableLiveData()
    var myResponseCountry: MutableLiveData<Response<ArrayList<Countres>>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            myResponseCountry.value = response
            Log.d("response",response.message().toString())

        }
    }
    fun getPostCities(cFlag:String){
        viewModelScope.launch {
            val response =repository.getPostCities(cFlag =cFlag)
            myResponse.value = response
            Log.d("response",response.message().toString())
        }

    }




}