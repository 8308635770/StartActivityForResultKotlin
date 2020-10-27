package com.example.startactivityforresultkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var tv_numbers:TextView
    lateinit var btn_add:Button
    lateinit var btn_sub:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tv_numbers=findViewById(R.id.text_view_numbers)
        btn_add=findViewById(R.id.button_add)
        btn_sub=findViewById(R.id.button_subtract)


        val intent=intent
        val number1=intent.getIntExtra("NUMBER1",0)
        val number2=intent.getIntExtra("NUMBER2",0)

        tv_numbers.setText("Two numbers are:"+number1+","+number2)

        btn_add.setOnClickListener(View.OnClickListener {

            val resultIntent=Intent()
            resultIntent.putExtra("RESULT",number1+number2)
            setResult(RESULT_OK,resultIntent)
            finish()

        })

        btn_sub.setOnClickListener(View.OnClickListener {
            val resultIntent=Intent()
            resultIntent.putExtra("RESULT",number1-number2)
            setResult(RESULT_OK,resultIntent)
            finish()
        })



    }
}