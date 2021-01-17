package com.example.lampung

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListLampungAdapter(private val listLampung: ArrayList<Lampung>) : RecyclerView.Adapter<ListLampungAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_lampung, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val lampung = listLampung[position]

        Glide.with(holder.itemView.context)
                .load(lampung.photo)
                .apply(RequestOptions())
                .into(holder.imgPhoto)

        holder.tvName.text = lampung.name
        holder.tvDetail.text = lampung.detail
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(lampung)
        }
    }

    override fun getItemCount(): Int {
        return listLampung.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Lampung)
    }

}