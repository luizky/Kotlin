package com.example.atividadeadapters01

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var etNomeAluno: EditText
    private lateinit var spinnerAreaEscolha: Spinner
    private lateinit var tvListaAlunos: TextView
    private lateinit var tvContadorAlunos: TextView
    private val listaAlunos = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNomeAluno = findViewById(R.id.etNomeAluno)
        spinnerAreaEscolha = findViewById(R.id.spinnerAreaEscolha)
        tvListaAlunos = findViewById(R.id.tvListaAlunos)
        tvContadorAlunos = findViewById(R.id.tvContadorAlunos)
        val btnInserir: Button = findViewById(R.id.btnInserir)
        val btnZerar: Button = findViewById(R.id.btnZerar)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaAlunos)

        btnInserir.setOnClickListener {
            val nomeAluno = etNomeAluno.text.toString()
            val areaEscolha = spinnerAreaEscolha.selectedItem.toString()
            val dataAtual = SimpleDateFormat("dd/MM", Locale.getDefault()).format(Date())

            if (nomeAluno.isNotEmpty()) {
                listaAlunos.add("$nomeAluno - $areaEscolha - $dataAtual")
                atualizarLista()
            }
        }

        btnZerar.setOnClickListener {
            listaAlunos.clear()
            atualizarLista()
        }
    }

    private fun atualizarLista() {
        tvListaAlunos.text = listaAlunos.joinToString("\n")
        tvContadorAlunos.text = "${listaAlunos.size} Alunos"
    }
}


/////

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/etNomeAluno"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nome Aluno" />

    <Spinner
        android:id="@+id/spinnerAreaEscolha"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:entries="@array/areas_escolha" />

    <Button
        android:id="@+id/btnInserir"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Inserir" />

    <TextView
        android:id="@+id/tvListaAlunos"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Lista de Alunos" />

    <TextView
        android:id="@+id/tvContadorAlunos"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="0 Alunos" />

    <Button
        android:id="@+id/btnZerar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="ZERAR"
        android:background="#FF0000"
        android:textColor="#FFFFFF" />
</LinearLayout>
