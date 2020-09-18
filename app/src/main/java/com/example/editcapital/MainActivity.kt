package com.example.editcapital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv)
        editText = findViewById(R.id.edit_text)
        button = findViewById(R.id.btnFix)

        button.setOnClickListener{
            Thread(Runnable {
                runOnUiThread {
                    textView.text = autoCorrectCapital(editText.text.toString())
                }
            }).start()

        }
    }
    fun autoCorrectCapital(s:String):String{
        var output = ""
        output += s[0].toUpperCase()
        output += s[1]
        for (i in 2 until s.length){
            if(output[i-1] == '.' || (s[i-2] == '.'&& s[i-1]==' '))
                output += s[i].toUpperCase()
            else
                output += s[i]
        }
        return output
    }
}