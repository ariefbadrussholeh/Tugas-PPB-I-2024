package com.ariefbadrussholeh.accessbykai.ui.screen.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.accessbykai.R
import com.ariefbadrussholeh.accessbykai.ui.components.BackgroundImage
import com.ariefbadrussholeh.accessbykai.ui.theme.AccessByKAITheme

@Composable
fun OnboardingScreen(
    navigateToRegistration: (() -> Unit),
    navigateToLogin: (() -> Unit)
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        BackgroundImage(
            image = painterResource(id = R.drawable.background),
            alpha = 0.5f
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            Header()
            Spacer(modifier = Modifier.height(350.dp))
            Action(
                navigateToRegistration = navigateToRegistration,
                navigateToLogin = navigateToLogin
            )
        }
    }
}

@Composable
private fun Header() {
    Image(
        painter = painterResource(id = R.drawable.ic_kai),
        contentDescription = null,
        modifier = Modifier.width(150.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Penuhi semua kebutuhan hanya dalam satu aplikasi",
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.width(230.dp)
    )
}

@Composable
private fun Action(
    navigateToRegistration: (() -> Unit),
    navigateToLogin: (() -> Unit)
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = navigateToRegistration,
            modifier = Modifier.width(240.dp)
        ) {
            Text(text = "DAFTAR")
        }
        Spacer(modifier = Modifier.height(4.dp))
        Button(
            onClick = navigateToLogin,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
            ),
            modifier = Modifier.width(240.dp)
        ) {
            Text(text = "MASUK")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LightThemePreview() {
    AccessByKAITheme {
        OnboardingScreen(navigateToRegistration = {}, navigateToLogin = {})
    }
}
@Preview(showBackground = true)
@Composable
private fun DarkThemePreview() {
    AccessByKAITheme(
        darkTheme = true
    ) {
        OnboardingScreen(navigateToRegistration = {}, navigateToLogin = {})
    }
}