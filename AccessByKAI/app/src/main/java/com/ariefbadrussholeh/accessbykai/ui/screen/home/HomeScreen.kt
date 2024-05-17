package com.ariefbadrussholeh.accessbykai.ui.screen.home

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ariefbadrussholeh.accessbykai.R
import com.ariefbadrussholeh.accessbykai.data.HomeData
import com.ariefbadrussholeh.accessbykai.data.articleData
import com.ariefbadrussholeh.accessbykai.data.promoData
import com.ariefbadrussholeh.accessbykai.ui.components.HomeTopBar
import com.ariefbadrussholeh.accessbykai.ui.theme.AccessByKAITheme

@Composable
fun HomeScreen(
    navigateToFindTicket: (() -> Unit),
) {
    Scaffold(
        topBar = {
            HomeTopBar()
        },
    ) { innerPadding ->
        val context = LocalContext.current
        BackHandler {
            (context as? Activity)?.finish()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(32.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    Header()
                }
                item {
                    FindTiketCard(
                        navigateToFindTicket = navigateToFindTicket
                    )
                }
                item {
                    Section(title = "Promo Terbaru", data = promoData)
                }
                item {
                    Section(title = "Artikel Menarik", data = articleData)
                }
            }
        }
    }
}

@Composable
private fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Mau pergi kemana kali ini?",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(180.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_kai),
            contentDescription = null,
            modifier = Modifier
                .height(50.dp)
        )
    }
}

@Composable
private fun Section(
    title: String,
    data: List<HomeData>
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Lihat Semua",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {  }
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(data) { item ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.width(200.dp)
                ) {
                    Image(
                        painter = item.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(width = 200.dp, height = 100.dp)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Text(
                        text = item.title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
private fun FindTiketCard(
    navigateToFindTicket: (() -> Unit)
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        var checked by remember {
            mutableStateOf(false)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .width(140.dp)
                        .clickable { }
                ) {
                    Text(
                        text = "Keberangkatan",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.alpha(0.7f)
                    )
                    Text(
                        text = "SGU",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Surabaya Gubeng",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
                Icon(
                    imageVector = Icons.Default.SwapHoriz,
                    contentDescription = null,
                    modifier = Modifier.clickable {  }
                )
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .width(140.dp)
                        .clickable { }
                ) {
                    Text(
                        text = "Tujuan",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.alpha(0.7f)
                    )
                    Text(
                        text = "ML",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Kota Malang",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.clickable {  }
                ) {
                    Text(
                        text = "Tanggal Keberangkatan",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.alpha(0.7f)
                    )
                    Text(
                        text = "Jum'at, 16 Mei 2024",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
                Button(
                    onClick = navigateToFindTicket,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                    ),
                ) {
                    Text(text = "CARI TIKET")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LightThemePreview() {
    AccessByKAITheme {
        HomeScreen(navigateToFindTicket = {})
    }
}
@Preview(showBackground = true)
@Composable
private fun DarkThemePreview() {
    AccessByKAITheme(
        darkTheme = true
    ) {
        HomeScreen(navigateToFindTicket = {})
    }
}