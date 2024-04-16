package com.ariefbadrussholeh.mycalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var num1 by remember {
                mutableStateOf("")
            }
            var num2 by remember {
                mutableStateOf("")
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = num1,
                    onValueChange = { num1 = it },
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    label = { Text("Number 1") },
                    placeholder = { Text(text = "0") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
                TextField(
                    value = num2,
                    onValueChange = { num2 = it },
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    label = { Text("Number 2") },
                    placeholder = { Text(text = "0") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
                Row(
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    Button(onClick = {
                        val result = (num1.toDoubleOrNull() ?: 0.0) + (num2.toDoubleOrNull() ?: 0.0)
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Add")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        val result = (num1.toDoubleOrNull() ?: 0.0) - (num2.toDoubleOrNull() ?: 0.0)
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Sub")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        val result = (num1.toDoubleOrNull() ?: 0.0) * (num2.toDoubleOrNull() ?: 0.0)
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Mul")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        val num2Value = num2.toDoubleOrNull() ?: 0.0
                        val result = (num1.toDoubleOrNull() ?: 0.0) / num2Value
                        Toast.makeText(applicationContext, "Result is $result", Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Div")
                    }
                }
            }
        }
    }
}