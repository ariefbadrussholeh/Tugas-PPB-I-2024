package com.ariefbadrussholeh.alfamind.ui.screen.home

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ariefbadrussholeh.alfamind.R
import com.ariefbadrussholeh.alfamind.data.Product
import com.ariefbadrussholeh.alfamind.data.discountedProducts
import com.ariefbadrussholeh.alfamind.data.mostProfitable
import com.ariefbadrussholeh.alfamind.data.mostSelled
import com.ariefbadrussholeh.alfamind.data.newProducts
import com.ariefbadrussholeh.alfamind.ui.components.ProductCard
import com.ariefbadrussholeh.alfamind.ui.navigation.Screen
import com.ariefbadrussholeh.alfamind.ui.screen.registration.RegistrationFormScreen
import com.ariefbadrussholeh.alfamind.ui.theme.AlfamindTheme
import com.ariefbadrussholeh.alfamind.util.toRupiah

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            HomeTopBar(
                navigateToStoreProfile = {
                    navController.navigate(Screen.StoreProfile.route)
                }
            )
        }
    ) {innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ){
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(vertical=24.dp)
            ) {
                item {
                    Category(
                        title = "Lagi Diskon",
                        products = discountedProducts,
                        navController = navController,
                    )
                }
                item {
                    Category(
                        title = "Paling Laku",
                        products = mostSelled,
                        navController = navController,
                    )
                }
                item {
                    Category(
                        title = "Produk Baru",
                        products = newProducts,
                        navController = navController,
                    )
                }
                item {
                    Category(
                        title = "Paling Untung",
                        products = mostProfitable,
                        navController = navController,
                    )
                }
            }
        }
    }
}

@Composable
fun Category(
    title: String,
    products: List<Product>,
    navController: NavController
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            OutlinedButton(
                onClick = {
                    navController.navigate(Screen.DetailCategory.createRoute(title))
                },
            ) {
                Text(text = "Lihat Semua")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(products) { product ->
                ProductCard(
                    product = product,
                    onClick = {
                        navController.navigate(Screen.DetailProduct.createRoute(product.code))
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    navigateToStoreProfile: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(16.dp, shape = RectangleShape, clip = false) // Add bottom shadow
    ) {
        CenterAlignedTopAppBar(
            title = { },
            navigationIcon = {
                Image(
                    painter = painterResource(id = R.drawable.logo_alfamind),
                    contentDescription = null,
                    modifier = Modifier.height(40.dp)
                )
            },
            actions = {
                IconButton(
                    onClick = navigateToStoreProfile,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.primary,
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                    )
                }
            },
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
//            HomeScreen()
        }
    }
}