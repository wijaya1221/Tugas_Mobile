package com.highground.angkotsmedan.fragments.list

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.highground.angkotsmedan.R
import com.highground.angkotsmedan.model.Angkot

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var angkotList = emptyList<Angkot>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = angkotList[position]
        holder.itemView.findViewById<TextView>(R.id.nomorAngkot_txt).text = currentItem.nomorAngkot
        holder.itemView.findViewById<TextView>(R.id.ruteAngkot_txt).text = currentItem.ruteAngkot
        holder.itemView.findViewById<TextView>(R.id.warnaAngkot_txt).text = currentItem.warnaAngkot

        holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout).setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(angkot: List<Angkot>){
        this.angkotList = angkot
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return  angkotList.size
    }
}