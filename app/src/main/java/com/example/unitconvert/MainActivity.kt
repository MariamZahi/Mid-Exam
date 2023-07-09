package com.example.unitconvert

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var enterEditText: EditText
    private lateinit var convertFromSpinner: Spinner
    private lateinit var convertToSpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
//View layout
enterEditText = findViewById(R.id.inputEditText)
convertFromSpinner = findViewById(R.id.conversionFromSpinner)
convertToSpinner = findViewById(R.id.conversionToSpinner)
convertButton = findViewById(R.id.convertButton)
resultTextView = findViewById(R.id.outputTextView)



