package com.example.internalstorage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var fileText: EditText
    var line:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fileText = findViewById(R.id.editText)
    }
    fun saveData(view: View) {
        try {
            val fileOutputStream = openFileOutput("file.text",Context.MODE_PRIVATE)
            val outputStreamWriter = OutputStreamWriter(fileOutputStream)
            outputStreamWriter.write(fileOutputStream.toString())
            outputStreamWriter.close()
            Toast.makeText(applicationContext,"Data Save",Toast.LENGTH_SHORT).show()
            fileText.setText("")
        }
        catch (exp : Exception)
        {
            exp.printStackTrace()
        }
    }
    fun readData(view: View) {
        try {
            val fileInputStream = openFileInput("file.text")
            val inputStreamReader = InputStreamReader(fileInputStream)

            val bufferReader = BufferedReader(inputStreamReader)
            val strinBuilder = StringBuilder()

            while ({line = bufferReader.readLine();line}() !=null)
            {
                strinBuilder.append(line)
            }
            fileInputStream.close()
            inputStreamReader.close()
            fileText.setText(strinBuilder.toString())

            Toast.makeText(applicationContext,"Data Retrieved...",Toast.LENGTH_SHORT).show()
        }
        catch (exp : Exception)
        {
            exp.printStackTrace()
        }
    }
}