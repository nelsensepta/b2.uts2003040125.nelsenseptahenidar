package com.example.b2uts2003040125nelsenseptahenidar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class IPKScreen : AppCompatActivity(), View.OnClickListener {

    private lateinit var angka1: TextView
    private lateinit var angka2: TextView
    private lateinit var angka3: TextView
    private lateinit var btnIPK: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ipkscreen)
        angka1 = findViewById(R.id.row1Angka);
        angka2 = findViewById(R.id.row2Angka);
        angka3 = findViewById(R.id.row3Angka);

        btnIPK = findViewById(R.id.hitungIPK);
        btnIPK.setOnClickListener(this)

    }
   override fun onClick(v: View?) {
        if (v?.id == R.id.hitungIPK) {


        }
    }
}

