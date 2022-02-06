package com.example.countryapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapi.R
import com.example.countryapi.model.Cities
import com.example.countryapi.model.Countres

class CitiesAdapter : RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {
    var citiList = emptyList<Cities>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val City_text: TextView = itemView.findViewById(R.id.Citie_txt)
        val id_city: TextView = itemView.findViewById(R.id.id_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_cities, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.City_text.text = citiList[position].name
        holder.id_city.text = citiList[position].id.toString()
    }

    override fun getItemCount(): Int {
        return citiList.size
    }

    fun setData(newList: ArrayList<Cities>?) {
        if (newList != null) {
            citiList = newList
        }
        notifyDataSetChanged()
    }
}