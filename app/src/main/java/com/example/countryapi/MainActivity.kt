package com.example.countryapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapi.databinding.ActivityMainBinding

import com.example.countryapi.model.Countres
import com.example.retrofitdemo.adapter.MyAdapter
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter(applicationContext) }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GetdataCountry()
        setRecylerView()

    }

    fun setRecylerView(){
        binding.recyclerView.adapter=myAdapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
    }

    fun GetdataCountry(){
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponseCountry.observe(this, { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    var countres: ArrayList<Countres>? = response.body()
                    myAdapter.setData(countres)
                    Log.d("IslamCountris", countres.toString())
                }
            } else {
                Log.d("Faillier", response.code().toString())
            }


        })


    }
}