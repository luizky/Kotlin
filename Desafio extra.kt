package br.unipar.primeiroprojetoandroid

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTemperatura = findViewById<EditText>(R.id.editTemperatura)
        val rbCelsiusParaFahrenheit = findViewById<RadioButton>(R.id.rbCelsiusParaFahrenheit)
        val rbFahrenheitParaCelsius = findViewById<RadioButton>(R.id.rbFahrenheitParaCelsius)
        val btnConverter = findViewById<Button>(R.id.btnConverter)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnConverter.setOnClickListener {
            val temperatura = inputTemperatura.text.toString()

            if (temperatura.isNotEmpty()) {
                val valorTemperatura = temperatura.toDouble()

                val resultado = when {
                    rbCelsiusParaFahrenheit.isChecked -> {
                        (valorTemperatura * 9 / 5) + 32
                    }
                    rbFahrenheitParaCelsius.isChecked -> {
                        (valorTemperatura - 32) * 5 / 9
                    }
                    else -> null
                }

                if (resultado != null) {
                    txtResultado.text = "Resultado: %.2f".format(resultado)
                } else {
                    txtResultado.text = "Selecione uma opção de conversão."
                }
            } else {
                txtResultado.text = "Por favor, insira uma temperatura."
            }
        }

        btnLimpar.setOnClickListener {
            inputTemperatura.setText("")
            txtResultado.text = ""
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
            android:text="Insira a temperatura:"
            android:textSize="18sp"
            android:paddingBottom="8dp"/>

        <EditText
            android:id="@+id/editTemperatura"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Digite a temperatura"
            android:inputType="numberDecimal"/>

        <RadioGroup
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical"
            android:layout_marginTop="16dp">

            <RadioButton
                android:id="@+id/rbCelsiusParaFahrenheit"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Celsius para Fahrenheit" />

            <RadioButton
                android:id="@+id/rbFahrenheitParaCelsius"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Fahrenheit para Celsius" />
        </RadioGroup>

        <Button
            android:id="@+id/btnConverter"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Converter"
            android:layout_marginTop="16dp"/>

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
            android:text="Limpar"
            android:layout_marginTop="16dp"/>
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
