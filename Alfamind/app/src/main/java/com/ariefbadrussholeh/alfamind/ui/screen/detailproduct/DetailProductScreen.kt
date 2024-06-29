package com.ariefbadrussholeh.alfamind.ui.screen.detailproduct

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ariefbadrussholeh.alfamind.data.Product
import com.ariefbadrussholeh.alfamind.data.discountedProducts
import com.ariefbadrussholeh.alfamind.data.mostProfitable
import com.ariefbadrussholeh.alfamind.data.mostSelled
import com.ariefbadrussholeh.alfamind.data.newProducts
import com.ariefbadrussholeh.alfamind.ui.components.ProductCard
import com.ariefbadrussholeh.alfamind.ui.components.TopBar
import com.ariefbadrussholeh.alfamind.ui.navigation.Screen
import com.ariefbadrussholeh.alfamind.ui.theme.AlfamindTheme
import com.ariefbadrussholeh.alfamind.util.toRupiah

@Composable
fun DetailProductScreen(
    productCode: String,
    navigateBack: () -> Unit
) {
    var product = discountedProducts.find { it.code == productCode }
    if (product == null) {
        product = mostSelled.find { it.code == productCode }
        if (product == null) {
            product = newProducts.find { it.code == productCode }
            if (product == null) {
                product = mostProfitable.find { it.code == productCode }
            }
        }
    }

    if (product != null) {
        Scaffold(
            topBar = {
                TopBar(title = "Detail Produk", navigateBack = navigateBack)
            }
        ) {innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    contentPadding = PaddingValues(24.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .background(Color(0xFFFAFAFA))
                                .fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = product.image),
                                contentDescription = null,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                    item {
                        Column {
                            Text(
                                text = product.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "Sisa " + product.stock,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.tertiary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    item {
                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = product.price.toRupiah(),
                                    style = MaterialTheme.typography.bodyMedium,
                                    textDecoration = TextDecoration.LineThrough,
                                    color = Color(0x50000000)
                                )
                                Text(
                                    text = ((product.discountedPrice / product.price - 1) * 100).toInt()
                                        .toString() + "%",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(MaterialTheme.colorScheme.secondary)
                                        .padding(4.dp)
                                        .clip(
                                            RoundedCornerShape(30.dp)
                                        )
                                )
                            }
                            Text(
                                text = product.discountedPrice.toRupiah(),
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    item {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Detail Produk",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                            DetailProduk(parameter = "Merk", value = product.brand)
                            DetailProduk(parameter = "Kategori", value = product.category)
                            DetailProduk(parameter = "Kode PLU", value = product.code)
                            DetailProduk(parameter = "Dimensi", value = product.dimension)
                            DetailProduk(parameter = "Berat", value = product.weight)
                            DetailProduk(parameter = "Stok", value = product.stock.toString())
                        }
                    }
                    item {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Deskripsi Produk",
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = product.description, style=MaterialTheme.typography.bodySmall)
                        }
                    }
                    item {
                        ElevatedButton(
                            onClick = { },
                            colors = ButtonDefaults.elevatedButtonColors(
                                contentColor = Color.White,
                                containerColor = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Tambah ke Keranjang",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DetailProduk(
    parameter: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = parameter, style=MaterialTheme.typography.bodySmall)
        Text(text = value, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
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
            DetailProductScreen(
                productCode = "ALGABED100200",
                navigateBack = { }
            )
        }
    }
}