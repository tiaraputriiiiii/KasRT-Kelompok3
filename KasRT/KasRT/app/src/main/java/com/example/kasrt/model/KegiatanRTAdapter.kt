package com.example.kasrt.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.R

class KegiatanRTAdapter(private val kegiatan: MutableList<DataItem>) :
    RecyclerView.Adapter<KegiatanRTAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_kegiatan, parent, false)
        return ListViewHolder(view)
    }

    fun setKegiatan(kegiatan: List<DataItem>) {
        this.kegiatan.clear()
        this.kegiatan.addAll(kegiatan)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = kegiatan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = kegiatan[position]
        holder.tvKegiatan.text = item.kegiatan_rt
        holder.tvTanggalKegiatan.text = item.tanggal_kegiatan
        holder.tvBiayaKegiatan.text = item.biaya_kegiatan
        holder.tvTempatKegiatan.text = item.tempat_kegiatan
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvKegiatan: TextView = itemView.findViewById(R.id.itemKegiatan)
        var tvTanggalKegiatan: TextView = itemView.findViewById(R.id.itemTanggalKegiatan)
        var tvBiayaKegiatan: TextView = itemView.findViewById(R.id.itemBiayaKegiatan)
        var tvTempatKegiatan: TextView = itemView.findViewById(R.id.itemTempatKegiatan)
    }
}
