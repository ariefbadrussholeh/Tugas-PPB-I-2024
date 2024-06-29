package com.ariefbadrussholeh.alfamind.ui.screen.detailcategory

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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

@Composable
fun DetailCategoryScreen(
    navController: NavController,
    categoryName: String
) {
    var products = emptyList<Product>()
    if (categoryName == "Lagi Diskon") {
        products = discountedProducts
    } else if (categoryName == "Paling Laku") {
        products = mostSelled
    } else if (categoryName == "Produk Baru") {
        products = newProducts
    } else if (categoryName == "Paling Untung") {
        products = mostProfitable
    }

    Scaffold(
        topBar = {
            TopBar(
                title = categoryName,
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(products.size) { index ->
                    ProductCard(
                        product = products[index],
                        onClick = {
                            navController.navigate(Screen.DetailProduct.createRoute(products[index].code))
                        }
                    )
                }
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
//            DetailCategoryScreen(categoryName = "Paling Laku")
        }
    }
}