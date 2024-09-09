package com.mistdev.proyectoghibli

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var btnRegistrar: Button
        lateinit var btnIniciarSesion: Button
        lateinit var nombreUsuario: EditText
        lateinit var contraseña: EditText
        lateinit var checkbox: CheckBox
        lateinit var toolbar: Toolbar

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.toolbarTitulo)

        nombreUsuario = findViewById(R.id.etNombreUsuario)
        contraseña = findViewById(R.id.etContraseña)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion)
        checkbox = findViewById(R.id.cbRecordarUsuario)

        btnRegistrar.setOnClickListener {
            val intent = Intent(this,InicioActivity::class.java)

            if(verificar(nombreUsuario.text.toString(),contraseña.text.toString(),intent) == true && checkbox.isChecked == true){
                Toast.makeText(this,"Se recordará el usuario",Toast.LENGTH_SHORT).show()
            }
        }

        btnIniciarSesion.setOnClickListener {
            val intent = Intent(this,InicioActivity::class.java)

            if(verificar(nombreUsuario.text.toString(),contraseña.text.toString(),intent) == true && checkbox.isChecked == true){
                Toast.makeText(this,"Se recordará el usuario",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun verificar(usuario: String, contraseña: String, intent: Intent): Boolean{
        if(usuario.isEmpty() == false && contraseña.isEmpty() == false){
            startActivity(intent)

            finish()
            return true
        } else {
            Toast.makeText(this,"No has ingresado el nombre de usuario o la contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
    }

}