package com.example.mvpdemo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpdemo.databinding.LayoutCountryListBinding
import com.example.mvpdemo.model.Countries
import javax.inject.Inject


class CountryAdapter @Inject constructor(): RecyclerView.Adapter<CountryAdapter.ViewHolder>(){

    private var list : List<Countries> ?= emptyList()

    fun setCountryList(list: List<Countries>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(val viewHolder: LayoutCountryListBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutCountryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewHolder.country= this.list?.get(position)

    }

    override fun getItemCount(): Int {
        return this.list?.size ?: 0
    }


}