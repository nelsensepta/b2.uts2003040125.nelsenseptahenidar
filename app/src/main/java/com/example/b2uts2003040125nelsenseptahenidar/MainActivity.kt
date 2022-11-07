package com.example.b2uts2003040125nelsenseptahenidar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.BigInteger


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var row1Nilai: EditText? =  null
    var row2Nilai: EditText? =  null
    var row3Nilai: EditText? =  null
    var row1Huruf: TextView? = null
    var row2Huruf: TextView? = null
    var row3Huruf: TextView? = null
    var IPK: TextView? = null
    var btnTampil: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        row1Nilai = findViewById<View>(R.id.row1Nilai) as EditText
        row2Nilai = findViewById<View>(R.id.row2Nilai) as EditText
        row3Nilai = findViewById<View>(R.id.row3Nilai) as EditText
        row1Huruf = findViewById<View>(R.id.row1Huruf) as TextView
        row2Huruf = findViewById<View>(R.id.row2Huruf) as TextView
        row3Huruf = findViewById<View>(R.id.row3Huruf) as TextView
        IPK = findViewById<View>(R.id.IPK) as TextView

        btnTampil = findViewById<View>(R.id.hitungNilai) as Button
        btnTampil!!.setOnClickListener(this)
    }

    fun getNilaiHuruf (nilai: Int): String{
        var grade: String = when  {
            nilai>=86 -> "A"
            nilai>=81 -> "A-"
            nilai>=76-> "B+"
            nilai>=71 -> "B"
            nilai>=66 -> "C+"
            nilai>=61 -> "C"
            nilai>=41 -> "D"
            else -> "E"
        }
        return grade;
    }

    fun getIPK (grade: Array<String>, SKS: Array<Int>): String{
        var ipk: String = ""
        var sum: Float = 0.0F
        var allSKS: Int =  SKS.size
        var i: Int = 0
        while (i <= allSKS -1) {
            sum += when (grade[i])  {
                "A" -> (SKS[i] * 4).toFloat()
                "A-" -> (SKS[i] * 3.5).toFloat()
                "B+" -> (SKS[i] * 3.25).toFloat()
                "B" -> (SKS[i] * 3).toFloat()
                "B-" -> (SKS[i] * 2.75).toFloat()
                "C+" -> (SKS[i] * 2.25).toFloat()
                "C" -> (SKS[i] * 2).toFloat()
                "D" -> (SKS[i] * 1).toFloat()
                else -> (SKS[i] * 0).toFloat()
            }
            i++
        }
        ipk =  String.format("%.2f", (sum / SKS.sum()))
        return ipk
    }
    override fun onClick(v: View) {

        if (v?.id == R.id.hitungNilai) {
            val nilai1 = row1Nilai?.text.toString().trim()
            val nilai2 = row2Nilai?.text.toString().trim()
            val nilai3 = row3Nilai?.text.toString().trim()

            var huruf = arrayOf(getNilaiHuruf(nilai1.toInt()), getNilaiHuruf(nilai2.toInt()), getNilaiHuruf(nilai3.toInt()))

            var allSKS = arrayOf(getString(R.string.row1SKS).toInt(), getString(R.string.row2SKS).toInt(), getString(R.string.row3SKS).toInt())

            var isEmptyFields = false

            var ipk = getIPK(huruf, allSKS)

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
                row1Huruf?.setText(huruf[0]).toString()
                row2Huruf?.setText(huruf[1]).toString()
                row3Huruf?.setText(huruf[2]).toString()
                IPK?.setText(ipk.toString()).toString()

            }

        }
    }
}



