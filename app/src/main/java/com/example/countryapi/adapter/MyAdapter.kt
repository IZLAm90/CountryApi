package com.example.retrofitdemo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapi.CitiesActivity
import com.example.countryapi.MainActivity
import com.example.countryapi.MainViewModel
import com.example.countryapi.R
import com.example.countryapi.model.Countres

class MyAdapter(context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private val context = context
    private var myList = emptyList<Countres>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countr_text: TextView = itemView.findViewById(R.id.Cuntry_txt)
        val iso2_text: TextView = itemView.findViewById(R.id.body_txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = myList[position]
        holder.countr_text.text = currentitem.name
        holder.iso2_text.text = currentitem.iso2

        holder.itemView.setOnClickListener {
            val intent: Intent = Intent(context, CitiesActivity::class.java)
            intent.putExtra("iso2", currentitem.iso2)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        }
    }

    fun setData(newList: ArrayList<Countres>?) {
        if (newList != null) {
            myList = newList
        }
        notifyDataSetChanged()
    }
}