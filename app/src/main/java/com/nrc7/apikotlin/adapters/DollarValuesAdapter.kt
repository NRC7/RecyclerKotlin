package com.nrc7.apikotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nrc7.apikotlin.R
import com.nrc7.apikotlin.models.Serie

class DollarValuesAdapter(private val list: List<Serie>,private val myListener: OnItemClickListener)
    : RecyclerView.Adapter<DollarValuesAdapter.DollarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DollarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_post,
            parent, false
        )
        return DollarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DollarViewHolder, position: Int) {
        val current = list[position]
        holder.text1.text = current.valor.toString()
        holder.text2.text = current.fecha
    }

    override fun getItemCount() = list.size

    // VIEWHOLDER
    inner class DollarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val text1: TextView = itemView.findViewById(R.id.text1)
        val text2: TextView = itemView.findViewById(R.id.text2)

        init {
            itemView.setOnClickListener(this);
        }

        override fun onClick(v: View?) {
            val position :Int = adapterPosition
            myListener.onItemClickListener(position);
        }
    }

    interface OnItemClickListener {
        fun onItemClickListener(position: Int)
    }
}