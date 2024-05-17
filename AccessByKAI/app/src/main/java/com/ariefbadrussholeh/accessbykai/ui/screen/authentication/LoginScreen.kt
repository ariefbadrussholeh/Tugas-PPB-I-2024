package com.ariefbadrussholeh.accessbykai.ui.screen.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.accessbykai.R
import com.ariefbadrussholeh.accessbykai.ui.common.screenModifier
import com.ariefbadrussholeh.accessbykai.ui.components.CustomOutlinedButtonWithIcon
import com.ariefbadrussholeh.accessbykai.ui.components.CustomOutlinedPasswordField
import com.ariefbadrussholeh.accessbykai.ui.components.CustomOutlinedTextField
import com.ariefbadrussholeh.accessbykai.ui.theme.AccessByKAITheme
import java.util.Vector

@Composable
fun LoginScreen(
    navigateToHome: (() -> Unit)
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Header()
            Main(navigateToHome = navigateToHome)
        }
        Footer()
    }
}

@Composable
private fun Header() {
    Column {
        Text(
            text = "Masuk Akun",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Silakan login dengan akun terdaftar",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun Main(
    navigateToHome: (() -> Unit)
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CustomOutlinedTextField(
            label = "Email atau Nomor Telepon",
            placeholder = "Masukkan email atau nomor telepon Anda",
            trailingIcon = Icons.Default.Email
        )
        CustomOutlinedPasswordField(
            label = "Kata Sandi",
            placeholder = "Masukkan kata sandi Anda",
        )
        Text(
            text = "Lupa Kata Sandi?",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.tertiary,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
        )
    }
    Button(
        onClick = navigateToHome,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "MASUK")
    }
    Text(
        text = "Atau menggunakan metode lain",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CustomOutlinedButtonWithIcon(
            label = "Masuk dengan Google",
            icon = painterResource(id = R.drawable.ic_google),
            onClick = {}
        )
        CustomOutlinedButtonWithIcon(
            label = "Masuk dengan Facebook",
            icon = painterResource(id = R.drawable.ic_facebook),
            onClick = {}
        )
    }
}

@Composable
private fun Footer() {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_bumn),
            contentDescription = null,
            modifier = Modifier.height(20.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_kai),
            contentDescription = null,
            modifier = Modifier.height(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LightThemePreview() {
    AccessByKAITheme {
        LoginScreen(navigateToHome = {})
    }
}
@Preview(showBackground = true)
@Composable
private fun DarkThemePreview() {
    AccessByKAITheme(
        darkTheme = true
    ) {
        LoginScreen(navigateToHome = {})
    }
}