package br.unipar.primeiroprojetoandroid
import android.annotation.SuppressLint
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
    @SuppressLint("MissingInflatedId")
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
        val valorInformadoConta = findViewById<EditText>(R.id.valordaConta)
        val porcentagemdaGorjeta = findViewById<EditText>(R.id.porcentagemGorjeta)
        val btnCalculo = findViewById<Button>(R.id.btnCalculo)
        btnCalculo.setOnClickListener {
            // Pega o valor do input da Tela
            val valorConta = valorInformadoConta.text.toString()
            val valorGorjeta = porcentagemdaGorjeta.text.toString()
            if (valorConta.isNotEmpty() && valorGorjeta.isNotEmpty()) {
                val porcentagemGorjeta = valorConta.toDouble() * (valorGorjeta.toDouble() / 100)
                val contaFinal = valorConta.toDouble() + porcentagemGorjeta
                resultado.text = "$contaFinal"
                resultado.text = "Valor da Gorjeta: $valorGorjeta . Valor da Conta com Gorjeta: $contaFinal"
            }else{
                resultado.text = "Informe ambos os valores"
            }
        }
        fun limparValores(view: View) {
            val resultado = findViewById<TextView>(R.id.txtResultado)
            val input = findViewById<EditText>(R.id.valordaConta)
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
            android:id="@+id/valorConta"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Valor da Conta:" />
        <EditText
            android:id="@+id/valordaConta"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="number" />
        <TextView
            android:id="@+id/numeroDois"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Porcentagem de gorjeta:" />
        <EditText
            android:id="@+id/porcentagemGorjeta"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="number" />
        <Button
            android:id="@+id/btnCalculo"
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
