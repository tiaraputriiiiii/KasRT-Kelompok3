package com.example.kasrt

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InformasiUmumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informasi_umum)
        val tvContact = findViewById<TextView>(R.id.tvContact)
        tvContact.text = "Kontak Layanan Pengguna: 085591448780"
    }
}