package com.example.countryapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapi.adapter.CitiesAdapter
import com.example.countryapi.model.Cities
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory

class CitiesActivity : AppCompatActivity() {
    private lateinit var ViewModel: MainViewModel
    private val CitiesAdapter by lazy { CitiesAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)
        val massge: String? = intent.getStringExtra("iso2")
        getCiti(massge)
        createRecycler()
        Toast.makeText(this, massge, Toast.LENGTH_LONG).show()

    }

    private fun createRecycler() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewCities)
        recyclerView.adapter = CitiesAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }

    private fun getCiti(n: String?) {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        ViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        if (n != null) {
            ViewModel.getPostCities(n)
        }
        ViewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    val arraycities: ArrayList<Cities>? = response.body()
                    CitiesAdapter.setData(arraycities)
                    /// Toast.makeText(this, response.body().toString(), Toast.LENGTH_LONG).show()
                    Log.d("Test", response.body().toString())
                }
            } else {
                Log.d("Faillier", response.code().toString())
            }
        })
    }

}