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

    val conversionFromOptions = arrayOf("Centimeters", "Inches", "Miles", "Kilometers", "Meters")
    val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionFromOptions)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    conversionFromSpinner.adapter = adapter
    val conversionToOptions = arrayOf("Millimeters", "Centimeters", "Kilometers" ,"Miles", "Inches")
    var adapterForTo = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionToOptions)
    adapterForTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    conversionToSpinner.adapter = adapterForTo

    convertButton.setOnClickListener { convertValue() }
}

private fun convertValue() {
    val inputValue = inputEditText.text.toString().toDoubleOrNull()

    if (inputValue != null) {
        val currentUnit = conversionFromSpinner.selectedItem.toString()
        val targetUnit = conversionToSpinner.selectedItem.toString()
        val result = when (currentUnit) {
            "Centimeters" -> convertCentimetersTo(targetUnit, inputValue)
            "Inches" -> convertInchesTo(targetUnit, inputValue)
            "Kilometers" -> convertKilometersTo(targetUnit, inputValue)
            "Miles" -> convertMilesTo(targetUnit, inputValue)
            "Meters" -> convertMetersTo(targetUnit, inputValue)

            else -> 0.0
        }
        var convertDoubleinputValue = inputValue.toInt();
        outputTextView.text = "$convertDoubleinputValue $currentUnit = $result $targetUnit"
    } else {
        outputTextView.text = "Please enter the convert value !"
    }
}




