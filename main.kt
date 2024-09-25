package com.example.fuelcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputH = findViewById<EditText>(R.id.inputH)
        val inputC = findViewById<EditText>(R.id.inputC)
        val inputS = findViewById<EditText>(R.id.inputS)
        val inputN = findViewById<EditText>(R.id.inputN)
        val inputO = findViewById<EditText>(R.id.inputO)
        val inputW = findViewById<EditText>(R.id.inputW)
        val inputA = findViewById<EditText>(R.id.inputA)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        calculateButton.setOnClickListener {
            try {
                val H = inputH.text.toString().toDouble()
                val C = inputC.text.toString().toDouble()
                val S = inputS.text.toString().toDouble()
                val N = inputN.text.toString().toDouble()
                val O = inputO.text.toString().toDouble()
                val W = inputW.text.toString().toDouble()
                val A = inputA.text.toString().toDouble()

                // Розрахунки сухої та горючої маси
                val dryFactor = 1 - W / 100
                val C_dry = C / dryFactor
                val H_dry = H / dryFactor
                val S_dry = S / dryFactor
                val N_dry = N / dryFactor
                val O_dry = O / dryFactor
                val A_dry = A / dryFactor

                val combustibleFactor = 1 - A_dry / 100
                val C_combustible = C_dry / combustibleFactor
                val H_combustible = H_dry / combustibleFactor
                val S_combustible = S_dry / combustibleFactor
                val N_combustible = N_dry / combustibleFactor
                val O_combustible = O_dry / combustibleFactor

                // Розрахунок нижчої теплоти згоряння (LHV)
                val LHV = 338 * C + 1442 * (H - O / 8) + 94 * S

                // Виведення результатів
                resultText.text = "Нижча теплота згоряння: %.2f кДж/кг".format(LHV)

            } catch (e: Exception) {
                Toast.makeText(this, "Будь ласка, введіть правильні числові значення!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
