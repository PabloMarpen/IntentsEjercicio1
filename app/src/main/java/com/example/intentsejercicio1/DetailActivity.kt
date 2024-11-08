package com.example.intentsejercicio1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var resultado : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    resultado = findViewById<TextView>(R.id.resultado)
    val volver = findViewById<Button>(R.id.volver)
        // capturamos el intent y recogemos los datos con el name que le hemos dado ademas al int le ponemos un dato por defecto
        val textoRecibido = intent.getStringExtra("nombre")
        val numeroRecibido = intent.getIntExtra("numero", 0)

        resultado.text = ("$textoRecibido, $numeroRecibido")
        // al pulsar el boton volver volvemos a la vista anterior
        volver.setOnClickListener(){
            onBackPressedDispatcher.onBackPressed()
        }

}
}