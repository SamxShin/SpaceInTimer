package com.bignerdranch.android.redo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.redo.data.Time
import kotlinx.android.synthetic.main.time_row.view.*


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var timeList = emptyList<Time>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.time_row, parent, false))
    }
    override fun getItemCount(): Int {
        return timeList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = timeList[position]
        holder.itemView.date_txt.text = currentItem.date
//        holder.itemView.completetime_txt.text = currentItem.comleteTime.toString()
        val totalTime =  currentItem.totalTime
        holder.itemView.totaltime_txt.text = "$totalTime:00"
    }
    fun setData(time: List<Time>){
        this.timeList = time
        notifyDataSetChanged()
    }
}