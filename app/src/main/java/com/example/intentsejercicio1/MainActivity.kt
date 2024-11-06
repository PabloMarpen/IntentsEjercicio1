package com.example.intentsejercicio1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var seekBar : SeekBar
    private lateinit var nombre : TextView
    private lateinit var button : Button
    private lateinit var resultado : TextView
    var nombreString = ""
    var numeroInt = 0

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

        if (result.resultCode == Activity.RESULT_OK) {

            nombreString = nombre.text.toString()
            resultado.text = nombreString + numeroInt
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

             nombre = findViewById<TextView>(R.id.nombre)
             seekBar = findViewById<SeekBar>(R.id.seekBar)
             button = findViewById<Button>(R.id.button)
            seekBar.min = 0
            seekBar.max = 10

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                numeroInt = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación en este caso
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // No se necesita implementación en este caso
            }
        })



        button.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            startForResult.launch(intent)
        }


        }
    }
