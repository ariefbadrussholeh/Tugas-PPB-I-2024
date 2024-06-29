package com.ariefbadrussholeh.alfamind.ui.screen.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.alfamind.ui.components.TopBar
import com.ariefbadrussholeh.alfamind.ui.theme.AlfamindTheme

@Composable
fun RegistrationOTPScreen(
    navigateBack: () -> Unit,
    navigateToRegistrationForm: () -> Unit
) {
    val otpLength = 4
    val otpValues = remember { mutableStateListOf("", "", "", "") }

    Scaffold(
        topBar = {
            TopBar(navigateBack = navigateBack)
        }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(horizontal = 36.dp)
            ) {
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "Masukkan Kode OTP Untuk Verifikasi",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Kode OTP sudah dikirim melalui WhatsApp ke nomor +(62)89514644904",
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        for (i in 0 until otpLength) {
                            InputBoxOTP(
                                otpValue = otpValues[i],
                                onValueChange = { newValue ->
                                    if (newValue.length <= 1) {
                                        otpValues[i] = newValue
                                    }
                                    if (otpValues.all { it.isNotEmpty() }) {
                                        navigateToRegistrationForm()
                                    }
                                }
                            )
                        }
                    }
                    Text(
                        text = "Kirim Ulang Kode? (1:58)",
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun InputBoxOTP(
    otpValue: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = otpValue,
        onValueChange = onValueChange,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.LightGray,
            unfocusedContainerColor = Color.LightGray,
            unfocusedTextColor = Color.Black,
            focusedBorderColor = Color.Black,
            focusedTextColor = Color.Black,
            cursorColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
        singleLine = true,
        modifier = Modifier.width(60.dp)
    )
}

@Preview()
@Composable
private fun ScreenPreview() {
    AlfamindTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RegistrationOTPScreen(
                navigateBack = { },
                navigateToRegistrationForm = { }
            )
        }
    }
}