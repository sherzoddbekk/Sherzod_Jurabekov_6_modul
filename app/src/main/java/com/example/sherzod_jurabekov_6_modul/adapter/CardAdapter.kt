package com.example.sherzod_jurabekov_6_modul.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sherzod_jurabekov_6_modul.R
import com.example.sherzod_jurabekov_6_modul.model.CardElement

class CardAdapter(var context: Context, var items: ArrayList<CardElement>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    @SuppressLint("NotifyDataSetChanged")
    fun addAll(photoList: ArrayList<CardElement>) {
        items.addAll(photoList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cards, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CardViewHolder) {
            holder.bind(position)
        }
    }

    override fun getItemCount(): Int {
        Log.d("TTT", items.size.toString())
        return items.size
    }

    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_number: TextView = view.findViewById(R.id.tv_cards_number)
        var tv_name: TextView = view.findViewById(R.id.tv_name_card)
        var tv_day: TextView = view.findViewById(R.id.tv_day_card)
        var tv_month: TextView = view.findViewById(R.id.tv_month_card)

        fun bind(position: Int) {
            val item = items[position]

            tv_number.text = item.cardnumber
            tv_day.text = item.day
            tv_name.text = item.cardname
            tv_month.text = item.month
        }
    }
}