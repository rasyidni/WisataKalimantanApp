package com.example.wisatakalimantan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wisatakalimantan.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.title = "Profil Saya"
    }
}