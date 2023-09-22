package com.example.kasirdina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPembeli = findViewById<EditText>(R.id.namapembeli)
        val namaBarang = findViewById<EditText>(R.id.namabarang)
        val jumlahBeli = findViewById<EditText>(R.id.jumlahbeli)
        val harga = findViewById<EditText>(R.id.harga)
        val uangBayar = findViewById<EditText>(R.id.uangbayar)
        val btnProses = findViewById<Button>(R.id.proses)
        val totalBelanja = findViewById<TextView>(R.id.totalbelanja)
        val kembalian = findViewById<TextView>(R.id.uangkembalian)
        val bonus = findViewById<TextView>(R.id.bonus)
        val keterangan = findViewById<TextView>(R.id.keterangan)
        val btnReset = findViewById<Button>(R.id.resetdata)

        btnProses.setOnClickListener {
            var total: Int = 0
            val jmlBeli = Integer.parseInt(jumlahBeli.text.toString())
            val hrg = Integer.parseInt(harga.text.toString())
            val bayar = Integer.parseInt(uangBayar.text.toString())

            total = jmlBeli * hrg
            val kembali = bayar - total

            totalBelanja.text = "Total Belanja: " + total.toString()
            kembalian.text = "Uang Kembalian: " + kembali.toString()

            if (bayar == total) {
                keterangan.text = "Keterangan: Uang Pas"
            }
            if (bayar < total) {
                keterangan.text = "Keterangan: Kurang bayar "+ abs(kembali)
            }
            if (bayar > total) {
                keterangan.text = "Keterangan: Kembalian " + kembali
            }

            if (total >= 200000) {
                bonus.text = "Bonus: Mouse"
            } else if (total >= 400000) {
                bonus.text = "Bonus: Keyboard"
            } else if (total >= 600000) {
                bonus.text = "Bonus: Hardisk"
            } else {
                bonus.text = "Bonus: Tidak ada Bonus"
            }
        }
        btnReset.setOnClickListener {
            namaPembeli.setText(" ")
            namaBarang.setText(" ")
            jumlahBeli.setText(" ")
            harga.setText(" ")
            uangBayar.setText(" ")
            totalBelanja.setText("Total Belanja")
            kembalian.setText("Uang Kembalian")
            bonus.setText("Bonus")
            keterangan.setText("Keterangan")
        }
    }
}

