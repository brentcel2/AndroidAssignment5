package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*


class nextnextpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextnextpage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,systemBars.bottom)
            insets
        }

        val rdGender:RadioGroup = findViewById(R.id.rdgender)
        val cbTerms:CheckBox = findViewById(R.id.cbTerms)
        val swEnable:Switch = findViewById(R.id.swEnable)

        val lbldis:TextView = findViewById(R.id.lblDis)

        val btnDis:Button = findViewById(R.id.btnDis)

        btnDis.setOnClickListener {
            val rbID = rdGender.checkedRadioButtonId

            var gender = " "
            if (rbID.toString().isNotEmpty()){
                val rbChosenGender:RadioButton = findViewById(rbID)
                gender = rbChosenGender.text.toString()
            }else{
                gender = "No chosen gender"
            }

            var terms = " "
            if(cbTerms.isChecked){
                terms = "Agree"
            }else{
                terms = "Not Agree"
            }

            var enable = " "
            if (swEnable.isChecked){
                enable = "Enabled"
            }else{
                enable = "Disabled"
            }

            lbldis.text = "Gender: " + gender + "\n Terms: " + terms + "\n Status: " + enable
        }

    }
}