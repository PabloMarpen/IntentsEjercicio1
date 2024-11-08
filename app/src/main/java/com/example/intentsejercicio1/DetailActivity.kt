package com.example.intentsejercicio1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var resultado : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    resultado = findViewById<TextView>(R.id.resultado)

        val textoRecibido = intent.getStringExtra("nombre")
        val numeroRecibido = intent.getIntExtra("numero", 0)
    resultado.text = ("$textoRecibido, $numeroRecibido")
}
}