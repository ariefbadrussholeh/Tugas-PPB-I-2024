package com.ariefbadrussholeh.alfamind.ui.screen.registration

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.alfamind.AlfamindApp
import com.ariefbadrussholeh.alfamind.R
import com.ariefbadrussholeh.alfamind.ui.theme.AlfamindTheme

@Composable
fun RegistrationHomeScreen(
    navigateRegistrationOTP: () -> Unit
) {
    var phoneNumber by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.run {
            background(MaterialTheme.colorScheme.primary)
                .fillMaxSize()
                .padding(horizontal = 36.dp, vertical = 48.dp)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_alfamind),
                contentDescription = null,
                modifier = Modifier.height(40.dp)
            )
            Column {
                Text(
                    text = "Jadi Store Owner di Alfamind",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Wujudkan mimpi kamu memiliki toko ritel sendiri dan dapatkan penghasilan yang melimpah",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
            }
            Image(
                painter = painterResource(id = R.drawable.vector_alfamind),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .align(Alignment.CenterHorizontally)
            )
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { newValue ->
                    phoneNumber = newValue
                },
                label = {
                    Text(text = "Nomor HP Kamu")
                },
                placeholder = {
                    Text(text = "Contoh: 08XXXXXXX")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    unfocusedLabelColor = Color(0X80FFFFFF),
                    unfocusedPlaceholderColor = Color(0X80FFFFFF),
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    focusedPlaceholderColor = Color(0X80FFFFFF),
                    focusedTextColor = Color.White,
                    cursorColor = Color.White,
                ),
                supportingText = {
                    Text(
                        text = "Dengan mendaftar atau masuk, Kamu secara otomatis menyetujui Syarat & Ketentuan yang berlaku.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            ElevatedButton(
                onClick = navigateRegistrationOTP,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Daftar",
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview()
@Composable
private fun ScreenPreview() {
    AlfamindTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            RegistrationHomeScreen(
                navigateRegistrationOTP = { }
            )
        }
    }
}