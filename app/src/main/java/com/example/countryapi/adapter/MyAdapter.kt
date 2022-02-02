package com.example.retrofitdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countryapi.R
import com.example.countryapi.model.Countres

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Countres>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      //  holder.itemView.userId_txt.text = myList[position].name.toString()
      //  holder.itemView.id_txt.text = myList[position].id.toString()
      //  holder.itemView.title_txt.text = myList[position].iso
     //   holder.itemView.body_txt.text = myList[position].body
    }

    fun setData(newList: List<Countres>){
        myList = newList
        notifyDataSetChanged()
    }
}