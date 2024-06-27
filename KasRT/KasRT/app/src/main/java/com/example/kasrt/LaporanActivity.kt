package com.example.kasrt

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kasrt.model.ResponseUser
import com.example.kasrt.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaporanActivity : AppCompatActivity() {

    private lateinit var adapter: PemanfaatanAdapter
    private lateinit var rvLaporan: RecyclerView
    private lateinit var jumlahIuranBulananTextView: TextView
    private lateinit var pengeluaranTextView: TextView
    private lateinit var totalIuranTextView: TextView
    private lateinit var unitRumahTextView: TextView
    private lateinit var unitRumahKasDoneTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)

        rvLaporan = findViewById(R.id.recyclerViewLaporan)
        jumlahIuranBulananTextView = findViewById(R.id.jumlahIuranBulananTextView)
        pengeluaranTextView = findViewById(R.id.pengeluaranTextView)
        totalIuranTextView = findViewById(R.id.totalIuranTextView)
        unitRumahTextView = findViewById(R.id.unitRumahTextView)
        unitRumahKasDoneTextView = findViewById(R.id.unitRumahKasDoneTextView)

        rvLaporan.layoutManager = LinearLayoutManager(this)
        adapter = PemanfaatanAdapter(mutableListOf())
        rvLaporan.adapter = adapter

        getPemanfaatan()
    }

    private fun getPemanfaatan() {
        val apiService = ApiConfig.getApiService()
        val client = apiService.getPemanfaatan()
        client.enqueue(object : Callback<ResponseUser> {
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful) {
                    val dataArray = response.body()?.data

                    if (dataArray != null) {
                        var totalIuranBulanan = 0
                        var totalPengeluaran = 0
                        var totalIuranIndividu = 0
                        var unitRumahCount = 0
                        var unitRumahKasDoneCount = 0

                        for (dataItem in dataArray) {
                            totalIuranBulanan += dataItem.jumlah_iuran_bulanan_warga
                            totalPengeluaran += dataItem.pengeluaran_iuran
                            totalIuranIndividu += dataItem.total_iuran_individu_warga * 3

                            unitRumahCount += dataItem.unit_rumah.toIntOrNull() ?: 0
                            unitRumahKasDoneCount += dataItem.unitrumah_sudah_membayar_kas.toIntOrNull() ?: 0
                        }

                        val rekapIuran = totalIuranIndividu - totalPengeluaran

                        jumlahIuranBulananTextView.text = "1. Jumlah Iuran Bulanan : $totalIuranBulanan"
                        pengeluaranTextView.text = "3. Total Pengeluaran : $totalPengeluaran"
                        totalIuranTextView.text = "4. Rekap Total Iuran : $rekapIuran"
                        unitRumahTextView.text = "5. Jumlah Unit Rumah : $unitRumahCount"
                        unitRumahKasDoneTextView.text = "6. Unit Rumah Sudah Bayar Kas : $unitRumahKasDoneCount"

                        adapter.setPemanfaatan(dataArray)
                    } else {
                        Toast.makeText(this@LaporanActivity, "Data not found", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@LaporanActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(this@LaporanActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }
        })
    }
}
