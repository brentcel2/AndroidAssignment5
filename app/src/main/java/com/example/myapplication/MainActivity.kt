package com.example.myapplication

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtnum1: EditText = findViewById(R.id.txtnum1)
        val txtnum2: EditText = findViewById(R.id.txtnum2)

        val lblOutput: TextView = findViewById(R.id.lblOutput)

        val btnSum: Button = findViewById(R.id.btnSum)
        val btnSub: Button = findViewById(R.id.btnSub)
        val btnMul: Button = findViewById(R.id.btnMul)
        val btnDiv: Button = findViewById(R.id.btnDiv)

        btnSum.setOnClickListener {
            val input1 = txtnum1.text.toString().toIntOrNull() ?: 0
            val input2 = txtnum2.text.toString().toIntOrNull() ?: 0

            val sum = input1 + input2

            lblOutput.text = "sum: " + sum
        }

        btnSub.setOnClickListener {
            val input1 = txtnum1.text.toString().toDoubleOrNull() ?: 0.0
            val input2 = txtnum2.text.toString().toDoubleOrNull() ?: 0.0

            val diff = input1 - input2

            lblOutput.text = "Difference: " + diff
        }
        btnMul.setOnClickListener {
            val input1 = txtnum1.text.toString().toFloatOrNull() ?: 0.0f
            val input2 = txtnum2.text.toString().toFloatOrNull() ?: 0.0f

            val prod = input1 * input2

            lblOutput.text = "Product: " + prod
        }
        btnDiv.setOnClickListener {
            val input1 = txtnum1.text.toString().toIntOrNull() ?: 0
            val input2 = txtnum2.text.toString().toIntOrNull() ?: 0

            val sum = input1 / input2

            lblOutput.text = "Quotient: " + sum
        }
    }
}