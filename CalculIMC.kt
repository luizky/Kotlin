package br.unipar.primeiroprojetoandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Dizer qual a tela que vai ser carregada
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val alturaInformado = findViewById<EditText>(R.id.AlturaInfo)
        val pesoConversao = findViewById<EditText>(R.id.PesoInfo)
        val botaoConversao = findViewById<Button>(R.id.btnIMC)

        botaoConversao.setOnClickListener {
            // Pega o valor do input da Tela

            val alturaInfo = alturaInformado.text.toString()
            val pesoInfo = pesoConversao.text.toString()


            if (alturaInfo.isNotEmpty() && pesoInfo.isNotEmpty()) {
                val calculo = pesoInfo.toDouble() / (alturaInfo.toDouble() * alturaInfo.toDouble());

            if (calculo < 18.4) {
                resultado.text = "IMC:${calculo} Abaixo do peso"
            }else if(calculo > 18.5 && calculo < 24.9){
                resultado.text = "IMC: ${calculo} Peso Normal"
            }else if(calculo > 25 && calculo < 29.9) {
                resultado.text = "IMC: ${calculo} Sobrepeso"
            }else if(calculo >= 30){
                resultado.text = "IMC: ${calculo} Obesidade"
            }

            }else{
                resultado.text = "Informe ambos os valores"
            }
        }

        fun limparValores(view: View) {

            val resultado = findViewById<TextView>(R.id.txtResultado)
            val input = findViewById<EditText>(R.id.AlturaInfo)

            resultado.setText("")
            input.setText("")

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
        android:layout_width="409dp"
        android:layout_height="729dp"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <TextView
            android:id="@+id/numeroUm"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Altura em metros:" />

        <EditText
            android:id="@+id/AlturaInfo"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="number" />

        <TextView
            android:id="@+id/numeroDois"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Peso em Kg:" />

        <EditText
            android:id="@+id/PesoInfo"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="number" />

        <Button
            android:id="@+id/btnIMC"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Calcular" />

        <TextView
            android:id="@+id/txtResultado"
            android:layout_width="match_parent"
            android:layout_height="65dp" />

        <Button
            android:id="@+id/btnLimpar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:onClick="limparValores"
            android:text="Limpar" />

    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
