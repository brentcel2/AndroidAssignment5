package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import androidx.core.widget.addTextChangedListener
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtInput: EditText = findViewById(R.id.txtInput)
        val lblDisplay2: TextView = findViewById(R.id.lblDisplay2)
        val lblvalid: TextView = findViewById(R.id.valid)
        val btnValid : Button = findViewById(R.id.btnValid)


        btnValid.setOnClickListener {
            val userIn = txtInput.text.toString()

            if (userIn.isEmpty()){
                lblvalid.text = "Please enter text"

            }else if(userIn.toIntOrNull() == null){
                lblvalid.text = "Please enter an integer"
            }


            else{
                lblvalid.text = null


                when (userIn.toInt()){
                    in 1 .. 3 ->{
                        lblDisplay2.text = "Baby"
                    }

                    in 4..12 ->{
                        lblDisplay2.text = "Child"
                    }

                    in 13..19 ->{
                        lblDisplay2.text = "Teens"
                    }

                    in 20..59 ->{
                        lblDisplay2.text = "Adult"
                    }

                    in 60..80 ->{
                        lblDisplay2.text = "Senior"
                    }

                    else -> {
                        lblDisplay2.text= "Immortal"
                    }



                }
            }

        }

        txtInput.addTextChangedListener {
            if(txtInput.text.toString().isNotEmpty()) {
                btnValid.isEnabled = true
            }
            else{
                btnValid.isEnabled= false
            }

        }


    }
}