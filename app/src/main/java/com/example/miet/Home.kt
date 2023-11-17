package com.example.miet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var btnDonations = findViewById<Button>(R.id.btnDonations)
        btnDonations.setOnClickListener {
            val intent = Intent(this, UploadGoods::class.java)
            startActivity(intent)
        }

        var btnViewDonations = findViewById<Button>(R.id.btnViewDonations)
        btnViewDonations.setOnClickListener {
            val intent = Intent(this, View::class.java)
            startActivity(intent)
        }

        var btnAboutUs = findViewById<Button>(R.id.btnAboutUs)
        btnAboutUs.setOnClickListener {
            val intent = Intent(this, More::class.java)
            startActivity(intent)
        }

        var btnMore = findViewById<Button>(R.id.btnMore)
        btnMore.setOnClickListener {
            val intent = Intent(this, More::class.java)
            startActivity(intent)
        }

        var btnSignOut = findViewById<Button>(R.id.btnSignOut)
        btnSignOut.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}