package com.brenobatista.desafiozup.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.brenobatista.desafiozup.Models.ServiceData
import com.brenobatista.desafiozup.R

class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.textViewListItem)

    fun bind(serviceData: ServiceData) {
        name.text = serviceData.serviceName
    }
}

val diffCallback = object : DiffUtil.ItemCallback<ServiceData>() {
    override fun areItemsTheSame(oldItem: ServiceData, newItem: ServiceData): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: ServiceData, newItem: ServiceData): Boolean {
        return oldItem == newItem
    }
}

class ReposAdapter : ListAdapter<ServiceData, RepoViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.service_item_layout, parent, false)
        return RepoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}