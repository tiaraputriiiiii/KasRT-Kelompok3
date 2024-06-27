package com.example.kasrt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.R
import com.example.kasrt.model.ResponseUser
import com.example.kasrt.model.KegiatanRTAdapter
import com.example.kasrt.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KegiatanRTActivity : AppCompatActivity() {
    private lateinit var adapter: KegiatanRTAdapter
    private lateinit var rv_kegiatan: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kegiatan)

        rv_kegiatan = findViewById(R.id.rv_kegiatan)
        adapter = KegiatanRTAdapter(mutableListOf())
        rv_kegiatan.layoutManager = LinearLayoutManager(this)
        rv_kegiatan.adapter = adapter

        getKegiatan()
    }

    private fun getKegiatan() {
        val apiService = ApiConfig.getApiService()
        val client = apiService.getKegiatan()
        client.enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful) {
                    val dataArray = response.body()?.data

                    if (dataArray != null) {
                        adapter.setKegiatan(dataArray)
                    }
                } else {
                    Toast.makeText(this@KegiatanRTActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(this@KegiatanRTActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}
