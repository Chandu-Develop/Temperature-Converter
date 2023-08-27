package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.temperatureconverter.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private var isUserUpdate = true
    private var df = DecimalFormat("#.####")
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val input1 = binding.celcius
        val input2 = binding.fahrenheit
        val input3 = binding.kelvin
        val clearButton = binding.btnClear

        clearButton.setOnClickListener {
            input1.text.clear()
            input2.text.clear()
            input3.text.clear()
        }
        binding.title.setOnClickListener {
            input1.text.clear()
            input2.text.clear()
            input3.text.clear()
        }

        input1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (isUserUpdate) {
                    val inputTemperature = p0.toString()

                    if (inputTemperature.isEmpty() ||
                        inputTemperature == "-" ||
                        inputTemperature == "+" ||
                        inputTemperature == ".") {
                        isUserUpdate = false
                        input2.text.clear()
                        input3.text.clear()
                        isUserUpdate = true
                    } else {
                        val inputTemperature = inputTemperature.toDouble()
                        isUserUpdate = false
                        input2.setText(df.format(inputTemperature * 9 / 5 + 32))
                        input3.setText(df.format(inputTemperature + 273))
                        isUserUpdate = true
                    }
                }
            }
        })

        input2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (isUserUpdate) {
                    val inputTemperature = p0.toString()

                    if (inputTemperature.isEmpty() ||
                        inputTemperature == "-" ||
                        inputTemperature == "+" ||
                        inputTemperature == ".") {
                        isUserUpdate = false
                        input1.text.clear()
                        input3.text.clear()
                        isUserUpdate = true
                    } else {
                        val inputTemperature = inputTemperature.toDouble()
                        isUserUpdate = false
                        input1.setText(df.format((inputTemperature - 32) * 5 / 9))
                        input3.setText(df.format((inputTemperature + 459.67) * 5 / 9))
                        isUserUpdate = true
                    }
                }
            }
        })

        input3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (isUserUpdate) {
                    val inputTemperature = p0.toString()

                    if (inputTemperature.isEmpty() ||
                        inputTemperature == "-" ||
                        inputTemperature == "+" ||
                        inputTemperature == ".") {
                        isUserUpdate = false
                        input1.text.clear()
                        input2.text.clear()
                        isUserUpdate = true
                    } else {
                        val inputTemperature = inputTemperature.toDouble()
                        isUserUpdate = false
                        input1.setText(df.format(inputTemperature - 273))
                        input2.setText(df.format((inputTemperature * 9 / 5) - 459.67))
                        isUserUpdate = true
                    }
                }
            }
        })
    }
}