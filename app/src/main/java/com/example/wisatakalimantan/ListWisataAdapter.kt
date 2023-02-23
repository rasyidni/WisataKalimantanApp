package com.example.wisatakalimantan

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wisatakalimantan.databinding.ItemRowWisataBinding

class ListWisataAdapter(private val listWisata: ArrayList<Wisata>) : RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {
    class ListViewHolder(val binding: ItemRowWisataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowWisataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listWisata.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, name, description) = listWisata[position]
        holder.binding.imgWisata.setImageResource(photo)
        holder.binding.tvNama.text = name
        val limitedText = limitWords(description, 20)
        holder.binding.tvDeskripsi.text = limitedText

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_wisata", listWisata[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    fun limitWords(string: String, limit: Int): String {
        val words = string.split(" ")
        val newString = StringBuilder()

        for (i in 0 until limit) {
            if (i >= words.size) {
                break
            }
            newString.append(words[i]).append(" ")
        }

        if (words.size > limit) {
            newString.append("...")
        }

        return newString.toString().trim()
    }
}