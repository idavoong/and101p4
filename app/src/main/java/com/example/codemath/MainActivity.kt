package com.example.codemath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputPrice = findViewById<EditText>(R.id.price)
        val seekBar: SeekBar = findViewById(R.id.seekBar)
        val displayPercentage: TextView = findViewById(R.id.percent)
        val button = findViewById<Button>(R.id.calculate)

        val displayTip: TextView = findViewById(R.id.tip)
        val displayTotal: TextView = findViewById(R.id.total)


        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                displayPercentage.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        button.setOnClickListener{
            val baseAmount = inputPrice.text.toString().toDouble()
            val tipPercent = seekBar.progress
            val tip = baseAmount * tipPercent / 100
            val total = baseAmount + tip

            displayTip.text = tip.toString()
            displayTotal.text = total.toString()
        }
    }

}