package com.example.wisataku2

import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Ambil data dari Intent
        val wisataName = intent.getStringExtra("WISATA_NAME")
        val wisataDescription = intent.getStringExtra("WISATA_DESCRIPTION")
        val wisataImage = intent.getIntExtra("WISATA_IMAGE", 0)
        val wisataWebsite = intent.getStringExtra("wisataWebsite")

        // Hubungkan view dengan data yang diterima
        val nameTextView: TextView = findViewById(R.id.detailWisataName)
        val descriptionTextView: TextView = findViewById(R.id.detailWisataDescription)
        val imageView: ImageView = findViewById(R.id.detailWisataImage)
        val websiteButton: Button = findViewById(R.id.webButton)

        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setNavigationOnClickListener {
            finish()
        }
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        // Set title if needed
        supportActionBar?.title = "Detail Wisata"

        // Untuk Set data ke TextViews dan ImageView
        nameTextView.text = wisataName
        descriptionTextView.text = wisataDescription
        imageView.setImageResource(wisataImage)

        websiteButton.setOnClickListener {
            wisataWebsite?.let {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                startActivity(intent)
            }
        }
    }
}