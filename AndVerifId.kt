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
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Dizer qual a tela que vai ser carregada

        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val inputIdade = findViewById<EditText>(R.id.edIdade)
        val botaoValidar = findViewById<Button>(R.id.btnVerificar)

                botaoValidar.setOnClickListener {

                    //Pega o valor do input da Tela

                    val idadeInformada = inputIdade.text.toString();

                    if(idadeInformada.isNotEmpty()){

                        val idadeInt = idadeInformada.toInt();
                        if(idadeInt <= 17){

                            resultado.setText("Você é menor de idade")

                        } else if(idadeInt <= 60) {

                            resultado.setText("Você está na meia idade")

                        } else {
                            resultado.setText("Você é idoso(a)")
                        }


                    } else {
                        resultado.setText("Informe um valor")
                    }


        }

    }

    // Outra forma de criar função para o botão
    fun limparValores(view: View){

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val input = findViewById<EditText>(R.id.edIdade)

        resultado.setText("")
        input.setText("")

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
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Qual Sua Idade?" />

        <EditText
            android:id="@+id/edIdade"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="number" />

        <Button
            android:id="@+id/btnVerificar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Verifica Idade" />

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
