package com.example.wisataku2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Wisata>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageId = arrayOf(
            R.drawable.danautoba,
            R.drawable.pantaipasir,
            R.drawable.pulaumursala,
            R.drawable.airterjunponot,
            R.drawable.cagar_alam_sibolangit,
            R.drawable.danau_linting,
            R.drawable.gunung_sibayak,
            R.drawable.pulau_samosir,
            R.drawable.salju_panas_dolok_tinggi_raja,
            R.drawable.taman_nasional_gunung_leuser
        )

        heading = resources.getStringArray(R.array.wisata_names)

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val wisata = Wisata(imageId[i], heading[i])
            newArrayList.add(wisata)
        }
        newRecyclerView.adapter = WisataAdapter(this, newArrayList)
    }
}
