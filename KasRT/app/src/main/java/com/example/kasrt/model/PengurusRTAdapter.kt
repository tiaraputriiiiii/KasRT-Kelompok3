package com.example.kasrt.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.kasrt.R

class PengurusRTAdapter(private val pengurus: MutableList<DataItem>) :
    RecyclerView.Adapter<PengurusRTAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_pengurus, parent, false)
        return ListViewHolder(view)
    }

    fun setPengurus(pengurus: List<DataItem>) {
        this.pengurus.clear()
        this.pengurus.addAll(pengurus)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = pengurus.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = pengurus[position]
        Glide.with(holder.itemView.context)
            .load(item.foto_pengurus)
            .apply(RequestOptions().override(80, 80).placeholder(R.drawable.avatar))
            .transform(CircleCrop())
            .into(holder.tvAvatar)
        holder.tvNamaPengurus.text = item.nama_pengurus
        holder.tvNoTeleponPengurus.text = item.notelepon_pengurus
        holder.tvJabatanPengurus.text = item.jabatan_pengurus
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
        var tvNamaPengurus: TextView = itemView.findViewById(R.id.itemName)
        var tvNoTeleponPengurus: TextView = itemView.findViewById(R.id.itemNoTelepon)
        var tvJabatanPengurus: TextView = itemView.findViewById(R.id.itemJabatan)
    }
}
