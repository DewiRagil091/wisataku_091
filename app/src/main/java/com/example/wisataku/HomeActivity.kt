package com.example.wisataku

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val kulinerButton: Button = findViewById(R.id.kulinerButton)
        val alamButton: Button = findViewById(R.id.alamButton)

            kulinerButton.setOnClickListener {
                val intent = Intent(this, WisataKulinerActivity::class.java)
                startActivity(intent)
            }

            alamButton.setOnClickListener {
                val intent = Intent(this, WisataAlamActivity::class.java)
                startActivity(intent)
        }
    }
}