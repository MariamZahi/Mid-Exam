import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.unitconvert.R

class MainActivity : AppCompatActivity() {
    private lateinit var inputEditText: EditText
    private lateinit var conversionFromSpinner: Spinner
    private lateinit var conversionToSpinner: Spinner
    private lateinit var convertButton: Button
    private lateinit var outputTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Introduce views
        inputEditText = findViewById(R.id.inputEditText)
        conversionFromSpinner = findViewById(R.id.conversionFromSpinner)
        conversionToSpinner = findViewById(R.id.conversionToSpinner)
        convertButton = findViewById(R.id.convertButton)
        outputTextView = findViewById(R.id.outputTextView)

        // Spinner for options
        val conversionFromOptions = arrayOf("Ounces", "Feet", "Meters", "Kilometers", "Miles")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionFromOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        conversionFromSpinner.adapter = adapter
        val conversionToOptions = arrayOf("Grams", "Centimeters", "Kilometers" ,"Miles", "Inches")
        var adapterForTo = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionToOptions)
        adapterForTo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        conversionToSpinner.adapter = adapterForTo
        // Set up the click listener for the convert button
        convertButton.setOnClickListener { convertValue() }
    }

    private fun convertValue() {
        val inputValue = inputEditText.text.toString().toDoubleOrNull()

        if (inputValue != null) {
            val currentUnit = conversionFromSpinner.selectedItem.toString()
            val targetUnit = conversionToSpinner.selectedItem.toString()
            val result = when (currentUnit) {
                "Ounces" -> convertOuncesTo(targetUnit, inputValue)
                "Feet" -> convertFeetTo(targetUnit, inputValue)
                "Meters" -> convertMetersTo(targetUnit, inputValue)
                "Miles" -> convertMilesTo(targetUnit, inputValue)
                "Kilometers" -> convertKilometersTo(targetUnit, inputValue)

                else -> 0.0
            }
            var convertDoubleinputValue = inputValue.toInt();
            outputTextView.text = "$convertDoubleinputValue $currentUnit = $result $targetUnit"
        } else {
            outputTextView.text = "Please enter the convert value !"
        }
    }

    private fun convertOuncesTo(unit: String, value: Double): Double {
        return when (unit) {
            "Ounces" -> value
            "Grams" -> value * 28.3

            else -> 0.0
        }
    }

    private fun convertFeetTo(unit: String, value: Double): Double {
        return when (unit) {
            "Feet" -> value
            "Inches" -> value / 12
            "Kilometers" -> value * 0.000305
             else -> 0.0
        }

    }

    private fun convertCentimetersTo(unit: String, value: Double): Double {
        return when (unit) {
            "Centimeters" -> value
            "Inches" -> value / 2.54
            "Kilometers" -> value / 100000
            "Miles" -> value / 160934
            "Millimeters" -> value * 10
            else -> 0.0
        }
    }
    private fun convertInchesTo(unit: String, value: Double): Double {
        return when (unit) {
            "Centimeters" -> value * 2.54
            "Inches" -> value
            "Kilometers" -> value / 39370.08
            "Miles" -> value / 63360
            "Millimeters" -> value * 25.4
            else -> 0.0
        }
    }
    private fun convertKgToPounds(kg: Double): Double {
        return kg / 0.5
    }
    private fun convertMilesTo(unit: String, value: Double): Double {
        return when (unit) {
            "Centimeters" -> value * 160934.4
            "Inches" -> value * 63360
            "Kilometers" -> value * 1.609344
            "Miles" -> value
            "Millimeters" -> value * 1609344.87
            else -> 0.0
        }
    }
    private fun convertKilometersTo(unit: String, value: Double): Double {
        return when (unit) {
            "Centimeters" -> value * 100000
            "Inches" -> value * 39370.08
            "Kilometers" -> value
            "Miles" -> value * 0.6213712
            "Millimeters" -> value * 1000000
            else -> 0.0
        }
    }

    private fun convertMetersTo(unit: String, value: Double): Double {
        return when (unit) {
            "Centimeters" -> value * 100
            "Inches" -> value / 0.0254
            "Kilometers" -> value / 1000
            "Miles" -> value /  1609.344
            "Millimeters" -> value * 1000
            else -> 0.0
        }
    }

}