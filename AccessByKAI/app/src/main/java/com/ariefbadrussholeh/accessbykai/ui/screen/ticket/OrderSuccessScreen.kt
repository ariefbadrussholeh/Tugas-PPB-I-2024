package com.ariefbadrussholeh.accessbykai.ui.screen.ticket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.accessbykai.R
import com.ariefbadrussholeh.accessbykai.ui.components.BackgroundImage
import com.ariefbadrussholeh.accessbykai.ui.theme.AccessByKAITheme

@Composable
fun OrderSuccessScreen(
    navigateToHome: (() -> Unit)
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        BackgroundImage(
            image = painterResource(id = R.drawable.background_2),
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize().alpha(.9f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(32.dp),
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .fillMaxWidth()
                    .padding(64.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Pembayaran Berhasil",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = "Pembayaran berhasil! Anda dapat melihat tiket Anda di menu Tiket Saya atau melalui email konfirmasi yang telah dikirimkan",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Button(
                    onClick = navigateToHome,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                    ),
                ) {
                    Text(text = "Kembali ke Beranda")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LightThemePreview() {
    AccessByKAITheme {
        OrderSuccessScreen(navigateToHome = {})
    }
}
@Preview(showBackground = true)
@Composable
private fun DarkThemePreview() {
    AccessByKAITheme(
        darkTheme = true
    ) {
        OrderSuccessScreen(navigateToHome = {})
    }
}