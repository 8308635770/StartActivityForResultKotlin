package com.example.startactivityforresultkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edittext_number1:EditText
    lateinit var edittext_number2:EditText
    lateinit var tv_result:TextView
    lateinit var btn_openActivity2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edittext_number1=findViewById(R.id.edit_text_number1)
        edittext_number2=findViewById(R.id.edit_text_number2)
        tv_result=findViewById(R.id.text_view_result)
        btn_openActivity2=findViewById(R.id.button_open_activity2)

        btn_openActivity2.setOnClickListener(View.OnClickListener {

            if(edittext_number1.text.toString().equals("")||edittext_number2.text.toString().equals("")){
                Toast.makeText(this,"Input fields are empty",Toast.LENGTH_SHORT).show()
            }else{
                val intent=Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("NUMBER1",Integer.parseInt(edittext_number1.text.toString()))
                intent.putExtra("NUMBER2",Integer.parseInt(edittext_number2.text.toString()))
                startActivityForResult(intent,1)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                val result= data?.getIntExtra("RESULT",0)
                tv_result.setText(result.toString())
            }
        }
    }
}