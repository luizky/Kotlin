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
        val primeiroInformado = findViewById<EditText>(R.id.primeiroNumero)
        val segundoInformado = findViewById<EditText>(R.id.segundoNumero)
        val botaoSoma = findViewById<Button>(R.id.btnSoma)
        val botaoSubtracao = findViewById<Button>(R.id.btnSub)

        botaoSoma.setOnClickListener {
            // Pega o valor do input da Tela
            val somaUm = primeiroInformado.text.toString()
            val somaDois = segundoInformado.text.toString()

            if (somaUm.isNotEmpty() && somaDois.isNotEmpty()) {
                val resultadoSoma = somaUm.toDouble() + somaDois.toDouble()
                resultado.text = resultadoSoma.toString()
            } else {
                resultado.text = "Informe ambos os valores"
            }
        }

        botaoSubtracao.setOnClickListener {
            // Pega o valor do input da Tela
            val subtUm = primeiroInformado.text.toString()
            val subtDois = segundoInformado.text.toString()

            if (subtUm.isNotEmpty() && subtDois.isNotEmpty()) {
                val resultadoSubtracao = subtUm.toDouble() - subtDois.toDouble()
                resultado.text = resultadoSubtracao.toString()
            } else {
                resultado.text = "Informe ambos os valores"
            }
        }

    }
    fun limparValores(view: View) {

        val resultado = findViewById<TextView>(R.id.txtResultado)
        val input = findViewById<EditText>(R.id.primeiroNumero)

        resultado.setText("")
        input.setText("")

    }
}
