package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        val resetBtn = findViewById<Button>(R.id.resetBtn)
        val resultText = findViewById<TextView>(R.id.result)

        val data = intent.extras
        var result = "none"
        if (data != null)
            result = data.getString("result").toString()

        resultText.text = result

        resetBtn.setOnClickListener { resetInputs() }
    }

    private fun resetInputs() {
        val mainActivityIntent = Intent(this@SecondActivity, MainActivity::class.java)
        startActivity(mainActivityIntent)
        finish()
    }
}