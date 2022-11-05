package com.example.b2uts2003040125nelsenseptahenidar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var row1Nilai: EditText? =  null
    var row2Nilai: EditText? =  null
    var row3Nilai: EditText? =  null
    var row1Angka: TextView? = null
    var row2Angka: TextView? = null
    var row3Angka: TextView? = null
    var btnTampil: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        row1Nilai = findViewById<View>(R.id.row1Nilai) as EditText
        row2Nilai = findViewById<View>(R.id.row2Nilai) as EditText
        row3Nilai = findViewById<View>(R.id.row3Nilai) as EditText
        row1Angka = findViewById<View>(R.id.row1Angka) as TextView
        row2Angka = findViewById<View>(R.id.row2Angka) as TextView
        row3Angka = findViewById<View>(R.id.row3Angka) as TextView

        btnTampil = findViewById<View>(R.id.hitungNilai) as Button
        btnTampil!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v?.id == R.id.hitungNilai) {
            val nilai1 = row1Nilai?.text.toString().trim()
            val nilai2 = row2Nilai?.text.toString().trim()
            val nilai3 = row3Nilai?.text.toString().trim()

            var isEmptyFields = false

            if (nilai1.isEmpty()) {
                isEmptyFields = true
                row1Nilai!!.error = "Field ini tidak boleh kosong"
            }
            if (nilai2.isEmpty()) {
                isEmptyFields = true
                row2Nilai!!.error = "Field ini tidak boleh kosong"
            }
            if (nilai3.isEmpty()) {
                isEmptyFields = true
                row3Nilai!!.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyFields) {
//                Setting Nilai Angka
            }

        }
    }
}