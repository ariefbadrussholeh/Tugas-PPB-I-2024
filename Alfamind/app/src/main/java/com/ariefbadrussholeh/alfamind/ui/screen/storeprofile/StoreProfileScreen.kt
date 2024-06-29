package com.ariefbadrussholeh.alfamind.ui.screen.storeprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.alfamind.R
import com.ariefbadrussholeh.alfamind.ui.components.TopBar
import com.ariefbadrussholeh.alfamind.ui.screen.registration.RegistrationHomeScreen
import com.ariefbadrussholeh.alfamind.ui.theme.AlfamindTheme

@Composable
fun StoreProfileScreen(
    navigateBack: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopBar(title = "Profil Toko", navigateBack = navigateBack)
        }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
                    .verticalScroll(scrollState)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_picture),
                        contentDescription = null,
                        modifier = Modifier
                            .width(100.dp)
                            .clip(CircleShape)
                    )
                    Column {
                        Text(
                            text = "Arief Badrus Sholeh's Store",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Toko aman, damai, terpercaya",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Informasi Toko",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        StoreInformation(parameter = "Lokasi", value = "Pamekasan, Jawa Timur")
                        StoreInformation(
                            parameter = "Jam Operasional",
                            value = "Senin-Minggu: 08:00-20:00 WIB"
                        )
                        StoreInformation(parameter = "Tanggal Bergabung", value = "25 Okt 2017")
                        StoreInformation(parameter = "Total Produk", value = "231")
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Deskripsi Toko",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Arief Badrus Sholeh Store adalah tempat yang menyediakan berbagai kebutuhan fashion dan perlengkapan sehari-hari dengan kualitas terbaik. Dengan komitmen untuk memberikan pelayanan terbaik kepada pelanggan, kami menyajikan koleksi pilihan yang trendy dan sesuai dengan gaya hidup Anda. Temukan produk-produk unggulan kami seperti pakaian, aksesoris, dan barang-barang kebutuhan lainnya di Arief Badrus Sholeh Store, tempat di mana gaya dan kenyamanan bertemu.",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
}

@Composable
fun StoreInformation(
    parameter: String,
    value: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = parameter,
            style = MaterialTheme.typography.bodySmall
        )
        Text(text = value, fontWeight = FontWeight.Medium)
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
            StoreProfileScreen(
                navigateBack = { }
            )
        }
    }
}