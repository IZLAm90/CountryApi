package com.example.countryapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countryapi.model.Countres
import com.example.retrofitdemo.adapter.MyAdapter
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel

    //   private val myAdapter by lazy { MyAdapter() }
    private lateinit var passiso: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getPost()
        viewModel.myResponseCountry.observe(this, { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    var countres: ArrayList<Countres>? = response.body()
                    Log.d("IslamCountris", countres.toString())
                    if (countres != null) {
                        passiso= countres.get(2).iso2
                        Log.d("passisoto get cities", passiso)
                        getCiti(passiso)
                    }
                }
            } else {
                Log.d("Faillier", response.code().toString())
            }


        })


    }
    private fun getCiti(n :String){
        viewModel.getPostCities(passiso)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.d("Test", response.body().toString())
                }
            } else {
                Log.d("Faillier", response.code().toString())
            }
        })
    }
    private fun setupRecyclerview() {
        //   recyclerView.adapter = myAdapter
        //   recyclerView.layoutManager = LinearLayoutManager(this)
    }
}