import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var nosScore = 0
    private var elesScore = 0
    private val maxScore = 12

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvNosScore: TextView = findViewById(R.id.tvNosScore)
        val tvElesScore: TextView = findViewById(R.id.tvElesScore)
        val btnNosIncrement: Button = findViewById(R.id.btnNosIncrement)
        val btnNosDecrement: Button = findViewById(R.id.btnNosDecrement)
        val btnElesIncrement: Button = findViewById(R.id.btnElesIncrement)
        val btnElesDecrement: Button = findViewById(R.id.btnElesDecrement)
        val btnReset: Button = findViewById(R.id.btnReset)

        btnNosIncrement.setOnClickListener {
            nosScore++
            tvNosScore.text = nosScore.toString()
            checkWinner("Nós", nosScore)
        }

        btnNosDecrement.setOnClickListener {
            if (nosScore > 0) nosScore--
            tvNosScore.text = nosScore.toString()
        }

        btnElesIncrement.setOnClickListener {
            elesScore++
            tvElesScore.text = elesScore.toString()
            checkWinner("Eles", elesScore)
        }

        btnElesDecrement.setOnClickListener {
            if (elesScore > 0) elesScore--
            tvElesScore.text = elesScore.toString()
        }

        btnReset.setOnClickListener {
            showResetDialog()
        }
    }

    private fun checkWinner(team: String, score: Int) {
        if (score >= maxScore) {
            AlertDialog.Builder(this)
                .setTitle("Fim do jogo")
                .setMessage("$team ganhou!")
                .setPositiveButton("OK") { _, _ ->
                    resetScores()
                }
                .setCancelable(false)
                .show()
        }
    }

    private fun showResetDialog() {
        AlertDialog.Builder(this)
            .setTitle("Zerar")
            .setMessage("Tem certeza que deseja começar novamente a pontuação?")
            .setPositiveButton("OK") { _, _ ->
                resetScores()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun resetScores() {
        nosScore = 0
        elesScore = 0
        findViewById<TextView>(R.id.tvNosScore).text = nosScore.toString()
        findViewById<TextView>(R.id.tvElesScore).text = elesScore.toString()
    }
}

/////

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/tvNos"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="NÓS"
        android:textSize="24sp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        android:padding="16dp"
        android:layout_marginStart="48dp"/>

    <TextView
        android:id="@+id/tvEles"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="ELES"
        android:textSize="24sp"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:padding="16dp"
        android:layout_marginEnd="48dp"/>

    <TextView
        android:id="@+id/tvNosScore"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="48sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tvNos"
        android:layout_marginTop="16dp"
        android:layout_marginStart="48dp" />

    <TextView
        android:id="@+id/tvElesScore"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="48sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tvEles"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="48dp" />

    <Button
        android:id="@+id/btnNosIncrement"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="+1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tvNosScore"
        android:layout_marginStart="48dp" />

    <Button
        android:id="@+id/btnNosDecrement"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="-1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/btnNosIncrement"
        android:layout_marginStart="48dp" />

    <Button
        android:id="@+id/btnElesIncrement"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="+1"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tvElesScore"
        android:layout_marginEnd="48dp" />

    <Button
        android:id="@+id/btnElesDecrement"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="-1"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/btnElesIncrement"
        android:layout_marginEnd="48dp" />

    <Button
        android:id="@+id/btnReset"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Zerar"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        android:layout_marginBottom="32dp" />
</androidx.constraintlayout.widget.ConstraintLayout>
