package com.example.miet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miet.databinding.ActivityAboutUsBinding

class AboutUs : AppCompatActivity() {

    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.redirectTextMore.setOnClickListener {
            val intent = Intent(this, More::class.java)
            startActivity(intent)
        }
    }
}