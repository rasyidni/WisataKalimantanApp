package com.example.wisatakalimantan

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.wisatakalimantan.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.title = "Detail Wisata"

        val dataWisata = intent.getParcelableExtra<Wisata>("key_wisata") as Wisata

        binding.tvNamawisata.text = dataWisata.name
        binding.imgWisata.setImageResource(dataWisata.photo)
        binding.tvAlamat.text = dataWisata.address
        binding.tvLuas.text = dataWisata.area
        binding.tvKeterangan.text = dataWisata.description
        binding.tvJeniswisata.text = dataWisata.type

        binding.actionShare.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND

            intent.type = "text/plain"

            intent.putExtra(Intent.EXTRA_TEXT, dataWisata.description)
            intent.putExtra(Intent.EXTRA_SUBJECT, dataWisata.name)

            startActivity(Intent.createChooser(intent, "Share via"))
        }
    }
}