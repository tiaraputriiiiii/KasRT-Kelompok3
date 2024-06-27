package com.example.kasrt.model


data class DataItem(
    val foto_warga: String,
    val nama_depan: String,
    val nama_belakang: String,
    val no_telepon: String,
    val email: String,
    val alamat: String,
    val jumlah_iuran_bulanan_warga: Int,
    val total_rekap_iuran_bulanan: Int,
    val jumlah_iuran_bulanan: Int,
    val total_iuran_individu_warga: Int,
    val pengeluaran_iuran: Int,
    val pemanfaatan_iuran: String,
    val unit_rumah: String,
    val unitrumah_sudah_membayar_kas: String,
    val foto_pengurus: String,
    val nama_pengurus: String,
    val notelepon_pengurus: String,
    val jabatan_pengurus: String,
    val kegiatan_rt: String,
    val tanggal_kegiatan: String,
    val biaya_kegiatan: String,
    val tempat_kegiatan: String,
)
