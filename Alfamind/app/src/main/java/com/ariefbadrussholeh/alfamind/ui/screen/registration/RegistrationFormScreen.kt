package com.ariefbadrussholeh.alfamind.ui.screen.registration

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.alfamind.R
import com.ariefbadrussholeh.alfamind.ui.components.TopBar
import com.ariefbadrussholeh.alfamind.ui.theme.AlfamindTheme

@Composable
fun RegistrationFormScreen(
    navigateToHome: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(horizontal = 36.dp)
            .verticalScroll(scrollState)

    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.vector_alfamind),
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
        )
        Text(
            text = "Yuk, siapkan Profil Toko Kamu untuk mulai Berjualan",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        InputForm(
            title = "Nama Kamu",
            placeholder = "Masukkan Nama Kamu"
        )
        InputForm(
            title = "Nama Toko",
            placeholder = "Masukkan Nama Tokomu"
        )
        InputForm(
            title = "Alamat Toko Saya",
            placeholder = "Masukkan Kecamatan, Kota/Kabupaten"
        )
        InputForm(
            title = "Kata Sandi",
            placeholder = "Masukkan Kata Sandi",
            isPassword = true
        )
        InputForm(
            title = "Ulangi Kata Sandi",
            placeholder = "Masukkan kembali Kata Sandi",
            isPassword = true
        )
        InputForm(
            title = "Referral",
            placeholder = "Masukkan Kode Referral Kamu"
        )
        ElevatedButton(
            onClick = navigateToHome,
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = Color.White,
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Daftar",
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun InputForm(
    title: String,
    placeholder: String,
    isPassword: Boolean = false
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        var input by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        Text(
            text = placeholder,
            style = MaterialTheme.typography.bodySmall
        )
        OutlinedTextField(
            value = input,
            onValueChange = { newValue ->
                input = newValue
            },
            placeholder = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodySmall
                )
            },
            visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if (isPassword) {
                    val image = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            },
            keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
            modifier = Modifier.fillMaxWidth()
        )
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
            RegistrationFormScreen(
                navigateToHome = { }
            )
        }
    }
}