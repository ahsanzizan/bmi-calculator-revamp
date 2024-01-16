package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateBtn = findViewById<Button>(R.id.calculateBtn)

        calculateBtn.setOnClickListener { calculate() }
    }

    private fun calculate() {
        var gender = "Laki - laki"
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        val genders = findViewById<RadioGroup>(R.id.radioGroupGender)

        val name = editTextName.text.toString()
        val address = editTextAddress.text.toString()
        val height = editTextHeight.text.toString().toDouble()
        val weight = editTextWeight.text.toString().toDouble()

        val selectedGender = genders.checkedRadioButtonId

        gender = when (selectedGender) {
            R.id.radioButtonMale -> "Laki-laki"
            R.id.radioButtonFemale -> "Perempuan"
            else -> "Laki-laki"
        }

        val bmi = when (gender) {
            "Laki-laki" -> weight / ((height / 100) * (height / 100))
            "Perempuan" -> weight / ((height / 100) * (height / 100)) * 0.9
            else -> 0.0
        }

        val result = "$name kamu berasal dari $address dan kamu " + when {
            bmi < 18.5 -> "Kekurangan gizi"
            bmi >= 18.5 && bmi < 24.9 -> "Normal"
            bmi >= 25 && bmi < 29.9 -> "Kelebihan gizi"
            else -> "Obesitas"
        }

        val secondActivityIntent = Intent(this@MainActivity, SecondActivity::class.java)
        val data = Bundle()
        data.putString("result", result)
        secondActivityIntent.putExtras(data)
        startActivity(secondActivityIntent)
        finish()
    }
}