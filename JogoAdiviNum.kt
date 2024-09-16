package br.unipar.primeiroprojetoandroid

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var numeroAleatorio: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numeroAleatorio = Random.nextInt(1, 101)

        val inputPalpite = findViewById<EditText>(R.id.editPalpite)
        val btnVerificar = findViewById<Button>(R.id.btnVerificar)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnVerificar.setOnClickListener {
            val palpite = inputPalpite.text.toString()

            if (palpite.isNotEmpty()) {
                val palpiteInt = palpite.toInt()

                when {
                    palpiteInt < numeroAleatorio -> {
                        txtResultado.text = "Seu palpite é muito baixo."
                    }
                    palpiteInt > numeroAleatorio -> {
                        txtResultado.text = "Seu palpite é muito alto."
                    }
                    else -> {
                        txtResultado.text = "Parabéns! Você acertou."
                    }
                }
            } else {
                txtResultado.text = "Por favor, insira um palpite."
            }
        }

        btnLimpar.setOnClickListener {
            inputPalpite.setText("")
            txtResultado.text = ""
            numeroAleatorio = Random.nextInt(1, 101)
        }
    }
}

/////

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Adivinhe o número (entre 1 e 100):"
            android:textSize="18sp"
            android:paddingBottom="8dp"/>

        <EditText
            android:id="@+id/editPalpite"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Digite seu palpite"
            android:inputType="number"/>

        <Button
            android:id="@+id/btnVerificar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Verificar"/>

        <TextView
            android:id="@+id/txtResultado"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:textSize="16sp"/>

        <Button
            android:id="@+id/btnLimpar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:text="Limpar"/>
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
