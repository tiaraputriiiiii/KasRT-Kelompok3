## Parsing JSON Android Studio

### Anggota Kelompok <br>

| Nama                      | NIM       | Kelas     | Mata Kuliah          |
| ------------------------- | --------- | --------- | -------------------- |
| Darmanto                  | 312210423 | TI.22.A.1 | Pemrograman Mobile 2 |
| Syifa Aurellia Rahma      | 312210009 | TI.22.A.1 | Pemrograman Mobile 2 |
| Tiara Putri               | 312210064 | TI.22.A.1 | Pemrograman Mobile 2 |


Tujuan Aplikasi:

Aplikasi menggunakan API spreadsheet untuk mengakses data keuangan secara real-time dari spreadsheet yang ada. Hal ini memungkinkan aplikasi untuk selalu mendapatkan informasi terkini tanpa perlu campur tangan manual.
Keuntungan Penggunaan Parsing JSON:

Otomatisasi Proses: Parsing JSON memungkinkan aplikasi untuk secara otomatis memproses data yang diambil dari spreadsheet, seperti perhitungan saldo, pembuatan laporan, dan visualisasi data.
Integrasi Mudah: Pendekatan ini memfasilitasi integrasi dengan aplikasi lain yang memerlukan data keuangan RT, seperti aplikasi pembukuan atau analisis keuangan.


Fitur-fitur Aplikasi:

- Daftar Warga: Menampilkan informasi lengkap warga yang terdaftar, termasuk nama, alamat, email, nomor telepon, dan iuran perwarga yang telah dibayarkan.
- Laporan Pemasukan: Menampilkan informasi mengenai jumlah iuran bulanan, total pengeluaran, rekap total, jumlah unit rumah, dan unit rumah yang sudah membayar kas.
- Informasi Pengurus: Informasi tentang nama, nomor telepon, dan jabatan pengurus RT.
- Informasi Kegiatan: Detail kegiatan seperti nama, tanggal, dana, dan tempat kegiatan yang diadakan di RT.
- Kontak Layanan Pengguna: Kontak yang dapat dihubungi untuk layanan pengguna aplikasi.
- Bagikan Info: Fasilitas untuk membagikan informasi melalui WhatsApp.


Langkah-langkah Praktikum:

Registrasi dan peroleh API key dari ApiSpreadsheets.
Tentukan ID spreadsheet yang berisi data keuangan RT.
Buat proyek Android baru di Android Studio.
Rancang desain antarmuka pengguna sesuai dengan kebutuhan aplikasi.
Implementasikan logika koneksi ke API menggunakan Retrofit atau pustaka HTTP klien lainnya.
Terapkan logika parsing JSON untuk mengambil dan memproses data dari respons API.
Tampilkan data yang diperoleh dalam antarmuka pengguna aplikasi Android.
Lakukan pengujian menyeluruh untuk memastikan semua fitur berjalan dengan baik dan data ditampilkan dengan benar.
Build Gradle Dependencies:
Berikut adalah daftar dependensi yang digunakan dalam aplikasi:

```
implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-messaging:24.0.0")
    implementation("com.google.firebase:firebase-inappmessaging-display:21.0.0")
    implementation("com.google.firebase:firebase-database:21.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("com.loopj.android:android-async-http:1.4.9")

    implementation("com.google.code.gson:gson:2.8.9")

    implementation("com.squareup.retrofit2:retrofit:2.6.4")
    implementation("com.squareup.retrofit2:converter-gson:2.6.4")

    implementation("com.squareup.okhttp3:logging-interceptor:3.8.0")
    debugImplementation("com.github.chuckerteam.chucker:library:3.3.0")

    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))
    implementation("com.google.firebase:firebase-analytics")

    implementation ("com.google.firebase:firebase-database:20.0.3")
    implementation("com.google.firebase:firebase-auth:21.0.3")

    implementation ("org.apache.poi:poi:5.2.2")
    implementation ("org.apache.poi:poi-ooxml:5.2.2")
    implementation ("org.apache.commons:commons-collections4:4.4")
```

Dokumentasi Tambahan:
- YouTube: Tautan ke Video YouTube
- PDF: Tautan ke Dokumen PDF

# Terima Kasih
