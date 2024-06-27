package com.example.kasrt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.model.PengurusRTAdapter
import com.example.kasrt.model.ResponseUser
import com.example.kasrt.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PengurusRTActivity : AppCompatActivity() {
    private lateinit var adapter: PengurusRTAdapter
    private lateinit var rv_pengurus: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengurus)

        rv_pengurus = findViewById(R.id.rv_pengurus)
        adapter = PengurusRTAdapter(mutableListOf())
        rv_pengurus.layoutManager = LinearLayoutManager(this)
        rv_pengurus.adapter = adapter

        getPengurus()
    }

    private fun getPengurus() {
        val apiService = ApiConfig.getApiService()
        val client = apiService.getPengurus()
        client.enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful) {
                    val dataArray = response.body()?.data

                    if (dataArray != null) {
                        adapter.setPengurus(dataArray)
                    }
                } else {
                    Toast.makeText(this@PengurusRTActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(this@PengurusRTActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}
